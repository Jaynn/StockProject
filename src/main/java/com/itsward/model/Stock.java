package com.itsward.model;

import com.itsward.constant.IStock;
import com.itsward.constant.IStockFrame;
import com.itsward.constant.basic.IExpression;
import com.itsward.constant.basic.IExpressionGroup;
import com.itsward.constant.basic.IIndicator;

import java.util.*;

public class Stock extends ArrayList<IStockFrame> implements IStock<IStockFrame> {
    private String name;
    private String code;

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public Map<IExpressionGroup, IIndicator> calculate(IExpression... expressions) {
        Map<IExpressionGroup, IIndicator> result = new HashMap<>();
        if (expressions != null) {
            Arrays.asList(expressions).stream().forEach(e -> {
                List list = e.getExpFunc().apply(this);
                if (!result.containsKey(e.getGroup())) {
                    IIndicator indicator = new Indicator();
                    indicator.setName(e.getGroup().getName());
                    indicator.setCode(e.getGroup().getCode());
                    result.put(e.getGroup(), indicator);
                }
                Indicator indicator = (Indicator) result.get(e.getGroup());
                indicator.put(e.getCode(), list);
            });
        }
        return result;
    }
}
