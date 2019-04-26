package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.rules.CommunityStatisticRules;
import com.otof.tecentmarketing.task.CallCommunitiesInfoTask;
import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import com.otof.tecentmarketing.entity.evaluation.CommunityEvaluation;
import com.otof.tecentmarketing.entity.PoiResponseEntity;
import com.otof.tecentmarketing.mapper.CommunityInfoMapper;
import com.otof.tecentmarketing.mapper.TempTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class CommunityStatisticService {

    private static final int SLEEPTIME = 1000;
    private static final double PAGEOFFSET = 20.00;
    private static final double HANDLEPAGEPERTHREAD = 5.00;
    @Autowired
    private HandleMapService handleMapService;
    @Autowired
    private CommunityInfoMapper communityInfoMapper;
    @Autowired
    private TempTableMapper tempTableMapper;
    @Autowired
    private CallCommunitiesInfoTask callCommunitiesInfoTask;
    @Autowired
    private CommunityStatisticRules communityStatisticRules;
    private List<String> communityNameList;

    public CommunityStatisticService() {
    }

    public CommunityEvaluation getCommunityInfos(String location, String radius, String types) throws URISyntaxException, InterruptedException {
        createTempCommunitiesNameTable(location, radius, types);
        return communityStatisticRules.analysisCommunities(communityInfoMapper.getCommunitiesInfoByNameList());
    }

    public CommunityEvaluation getCommunityStatistic(String location, String radius, String types) throws URISyntaxException, InterruptedException {
        createTempCommunitiesNameTable(location, radius, types);
        return communityInfoMapper.getCommunityStatisticByNameList();
    }

    private void createTempCommunitiesNameTable(String location, String radius, String types) throws URISyntaxException, InterruptedException {
        List<Future> futures = new ArrayList<>();
        communityNameList = new ArrayList<>();
        tempTableMapper.deleteTempCommunitiesName();
        ResponseEntity<PoiResponseEntity> poiResponse
                = handleMapService.getCommunitiesByLocation(location, radius, types, 0);
        PoiResponseEntity poiEntity = poiResponse.getBody();
        int maxPageNumber = (int)Math.ceil(Double.parseDouble(poiEntity.getCount()) / PAGEOFFSET);
        int threadNumber = (int)Math.ceil(Double.parseDouble(poiEntity.getCount()) / PAGEOFFSET / HANDLEPAGEPERTHREAD);

        for (int i = 1; i <= threadNumber; i++) {
            int minPage = (i-1)*10;
            int maxPage = (i*10-1) < maxPageNumber ? (i*10-1) : maxPageNumber;
            Future future = callCommunitiesInfoTask.doTaskCallCommunitiesInfo(location, radius, types, minPage, maxPage);
            futures.add(future);
        }
        while (true) {
            if (futures.stream().allMatch(v -> v.isDone())) {
                futures.forEach(v -> {
                    try {
                        communityNameList.addAll((List<String>) v.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });
                break;
            }
            Thread.sleep(SLEEPTIME);
        }
        tempTableMapper.insertTempCommunitiesName(communityNameList);
    }
}
