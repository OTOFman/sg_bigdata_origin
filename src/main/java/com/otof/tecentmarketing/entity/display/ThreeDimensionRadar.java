package com.otof.tecentmarketing.entity.display;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Setter
@Getter
public class ThreeDimensionRadar {

    private String label;
    private List<Integer> data;
    private List<String> backgroundColor;
    private List<String> borderColor;
    private int borderWidth;

    public ThreeDimensionRadar() {
        backgroundColor = Arrays.asList("rgba(255, 99, 132, 0.2)");
        borderColor = Arrays.asList("rgba(255, 99, 132, 1)");
        borderWidth = 1;
    }
}
