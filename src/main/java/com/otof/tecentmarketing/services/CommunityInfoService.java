package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.CommunityInfoEntity;
import com.otof.tecentmarketing.entity.CommunityStatisticEntity;
import com.otof.tecentmarketing.entity.PoiResponseEntity;
import com.otof.tecentmarketing.mapper.CommunityInfoMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommunityInfoService {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CommunityInfoService.class);


    private int maxPageNumber = 100;
    @Autowired
    private HandleMapService handleMapService;
    @Autowired
    private CommunityInfoMapper communityInfoMapper;
    private List<String> communityNameList;

    public CommunityInfoService() {
    }

    public Set<CommunityInfoEntity> getCommunityInfos(String location, String radius, String types, int currentPage) throws URISyntaxException {
        communityNameList = new ArrayList<>();
        ResponseEntity<PoiResponseEntity> poiResponse = handleMapService.getCommunitiesByLocation(location, radius, types, currentPage);
        PoiResponseEntity poiEntity = poiResponse.getBody();
        if (poiEntity.getPois().size() != 0) {
            poiEntity.getPois().stream().forEach(v -> communityNameList.add(v.getName()));
            return communityInfoMapper.getCommunitiesInfoByNameList(communityNameList);
        }

        return new HashSet<>();
    }

    public CommunityStatisticEntity getCommunityStatistic(String location, String radius, String apartmenttype) throws URISyntaxException {
        int currentPage = 1;
        CommunityStatisticEntity communityStatisticEntity = new CommunityStatisticEntity();
        while (currentPage <= maxPageNumber) {
            communityNameList = new ArrayList<>();
            ResponseEntity<PoiResponseEntity> poiResponse = handleMapService.getCommunitiesByLocation(location, radius, apartmenttype, currentPage);
            PoiResponseEntity poiEntity = poiResponse.getBody();
            if (poiEntity.getPois().size() == 0) {
                break;
            }

            poiEntity.getPois().stream().forEach(v -> communityNameList.add(v.getName()));
            communityStatisticEntity.add(communityInfoMapper.getCommunityStatisticByNameList(communityNameList));
            currentPage++;
        }
        return communityStatisticEntity;
    }
}
