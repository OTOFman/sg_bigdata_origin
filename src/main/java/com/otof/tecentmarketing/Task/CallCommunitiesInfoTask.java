package com.otof.tecentmarketing.Task;

import com.otof.tecentmarketing.entity.PoiResponseEntity;
import com.otof.tecentmarketing.services.HandleMapService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class CallCommunitiesInfoTask {
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CallCommunitiesInfoTask.class);

    @Autowired
    private HandleMapService handleMapService;
    @Async
    public Future<List> doTaskCallCommunitiesInfo(String location, String radius, String types, int minPage, int maxPage) throws URISyntaxException {
        int currentPage = minPage;
        List<String> communityNameList = new ArrayList<>();
        while (currentPage <= maxPage) {
            logger.info("start task for page: " + currentPage);

            ResponseEntity<PoiResponseEntity> poiResponse = handleMapService.getCommunitiesByLocation(location, radius, types, currentPage);
            PoiResponseEntity poiEntity = poiResponse.getBody();

            if (poiEntity.getPois().size() != 0) {
                poiEntity.getPois().stream().forEach(v -> communityNameList.add(v.getName()));
            }
            currentPage++;
        }
        return new AsyncResult<>(communityNameList);
    }
}
