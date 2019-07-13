package com.itsward.model;

import com.itsward.constant.basic.IIndicator;

import java.util.HashMap;
import java.util.List;

public class Indicator extends HashMap<String, List> implements IIndicator {
    private String name;
    private String code;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }
}
