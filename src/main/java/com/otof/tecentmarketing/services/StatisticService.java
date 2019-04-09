package com.otof.tecentmarketing.services;

import com.otof.tecentmarketing.entity.PoisEntity;

import java.net.URISyntaxException;
import java.util.List;

public interface StatisticService {
    List<PoisEntity> getSurroundPois(String location, String radius) throws URISyntaxException, InterruptedException;
}
