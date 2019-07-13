package com.itsward.model;

import com.itsward.constant.basic.INameCode;

public abstract class _NameCode implements INameCode {
    private String name;
    private String code;

    public _NameCode() {
    }

    public _NameCode(String name, String code) {
        this.name = name;
        this.code = code;
    }

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
