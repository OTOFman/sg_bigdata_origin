package com.otof.tecentmarketing.requests;

import com.otof.tecentmarketing.entity.PoisEntity;
import com.otof.tecentmarketing.entity.RequestCretiraEntity;
import com.otof.tecentmarketing.task.CallMultiplePageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class MultiplePageRequest {

    private final int PAGEOFFSET = 20;
    private final int HANDLEPAGEPERTHREAD = 5;
    private final int SLEEPTIME = 1000;

    @Autowired
    private CallMultiplePageInfo callMultiplePageInfo;

    public List<PoisEntity> getAllResultsByRequest(RequestCretiraEntity requestCretiraEntity, String totalAmount) throws InterruptedException {
        List<PoisEntity> poisEntityList = new ArrayList<>();
        int maxPageNumber = (int)Math.ceil(Double.parseDouble(totalAmount) / PAGEOFFSET);
        int threadNumber = (int)Math.ceil(Double.parseDouble(totalAmount) / PAGEOFFSET / HANDLEPAGEPERTHREAD);
        List<Future> futures = new ArrayList<>();
        for (int i = 1; i <= threadNumber; i++) {
            int minPage = (i-1)*10;
            int maxPage = (i*10-1) < maxPageNumber ? (i*10-1) : maxPageNumber;
            Future future = callMultiplePageInfo.doTaskCallMultiplePageInfo(requestCretiraEntity, minPage, maxPage);
            futures.add(future);
        }
        while (true) {
            if (futures.stream().allMatch(v -> v.isDone())) {
                futures.forEach(v -> {
                    try {
                        poisEntityList.addAll((List<PoisEntity>) v.get());
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
        return poisEntityList;
    }
}
