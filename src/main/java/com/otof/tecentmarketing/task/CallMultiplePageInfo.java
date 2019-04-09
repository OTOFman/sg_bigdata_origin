package com.otof.tecentmarketing.task;

import com.otof.tecentmarketing.entity.PoiResponseEntity;
import com.otof.tecentmarketing.entity.PoisEntity;
import com.otof.tecentmarketing.entity.RequestCretiraEntity;
import com.otof.tecentmarketing.requests.HandleMultiplePageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Component
public class CallMultiplePageInfo {

    @Autowired
    private HandleMultiplePageRequest handleMultiplePageRequest;

    @Async
    public Future<List> doTaskCallMultiplePageInfo(RequestCretiraEntity requestCretiraEntity, int minPage, int maxPage) {
        int currentPage = minPage;
        List<PoisEntity> responseList = new ArrayList<>();
        while (currentPage <= maxPage) {
            ResponseEntity<PoiResponseEntity> responseEntity = handleMultiplePageRequest.getInfoFromSpecificPage(requestCretiraEntity, currentPage);
            responseList.addAll(responseEntity.getBody().getPois());
            currentPage++;
        }
        return new AsyncResult<>(responseList);
    }
}
