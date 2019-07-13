package com.itsward.model;

import com.itsward.constant.IStockFrame;
import com.itsward.constant.basic.IExpression;
import com.itsward.constant.basic.IExpressionGroup;

import java.util.List;
import java.util.function.Function;

public abstract class _Expression extends _NameCode implements IExpression {
    private IExpressionGroup group;

    public _Expression() {
    }

    public _Expression(String name, String code) {
        super(name, code);
    }

    public _Expression(String name, String code, IExpressionGroup group) {
        super(name, code);
        this.group = group;
    }

    @Override
    public Function<List<IStockFrame>, List> getExpFunc() {
        return s -> s;
    }

    @Override
    public IExpressionGroup getGroup() {
        return group;
    }

    public void setGroup(IExpressionGroup group) {
        this.group = group;
    }
}
