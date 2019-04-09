package com.otof.tecentmarketing.enums;

public enum KiloEnum {
    ONEKILOMETER(1, "1000", 0.5),
    TWOKILOMETER(2, "2000", 0.3),
    THREEKILOMETER(3, "3000", 0.2);

    public int index;
    public String radius;
    public double ratio;

    private KiloEnum(int index, String radius, double ratio) {
        this.index = index;
        this.radius = radius;
        this.ratio = ratio;
    }
}
