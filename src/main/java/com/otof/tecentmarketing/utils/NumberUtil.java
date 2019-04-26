package com.otof.tecentmarketing.utils;

public class NumberUtil {

    public static boolean isBetween(double number, double minValueInclusive, double maxValueInclusie) {
        return number >= minValueInclusive && number <= maxValueInclusie;
    }

    public static boolean isBetweenMaxExclude(double number, double minValueInclusive, double maxValueInclusie) {
        return number >= minValueInclusive && number < maxValueInclusie;
    }

    public static boolean isBetweenMinExclude(double number, double minValueInclusive, double maxValueInclusie) {
        return number > minValueInclusive && number <= maxValueInclusie;
    }
}
