package com.otof.tecentmarketing.entity;

import org.apache.http.NameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NameValueEntity implements NameValuePair {

    private String name;
    private String value;

    private NameValueEntity(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public static List<NameValuePair> buildNvpList(Map<String, String> map) {
        List<NameValuePair> nameValueEntities =new ArrayList<>();
        map.forEach( (k,v) -> nameValueEntities.add(new NameValueEntity(k, v)));
        return nameValueEntities;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }
}
