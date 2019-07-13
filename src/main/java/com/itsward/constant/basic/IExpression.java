package com.itsward.constant.basic;

import com.itsward.constant.IStockFrame;

import java.util.List;
import java.util.function.Function;

public interface IExpression extends INameCode {
    Function<List<IStockFrame>, List> getExpFunc();

    IExpressionGroup getGroup();
}
