package com.itsward.constant.basic;

import java.util.Map;

public interface ICalculate {
    Map<IExpressionGroup, IIndicator> calculate(IExpression... expressions);
}
