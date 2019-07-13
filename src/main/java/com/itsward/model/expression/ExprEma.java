package com.itsward.model.expression;

import com.itsward.constant.IStockFrame;
import com.itsward.model._Expression;
import com.itsward.model.ExpressionGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExprEma extends _Expression {
    private static final String NAME_VALUE = "Exponential Moving Average";
    private static final String CODE_VALUE = "EMA";
    private int n = 5;
    private Function<IStockFrame, Number> calculTreatValueFunc = IStockFrame::getClose;

    public ExprEma(ExpressionGroup expressionGroup) {
        super(NAME_VALUE, CODE_VALUE, expressionGroup);
    }

    public ExprEma(int n, ExpressionGroup expressionGroup) {
        super(NAME_VALUE, CODE_VALUE, expressionGroup);
        this.n = n;
    }

    @Override
    public Function<List<IStockFrame>, List> getExpFunc() {
        // 开始计算EMA值，

        return s -> {
            List<Number> sources = s.stream().map(this.calculTreatValueFunc).collect(Collectors.toList());
            Double[] result = new Double[sources.size()];
            Double k = 2.0 / (n + 1.0);// 计算出序数
            Double ema = sources.get(0).doubleValue();// 第一天ema等于当天收盘价
            result[0] = ema;
            for (int i = 1; i < sources.size(); i++) {
                // 第二天以后，当天收盘 收盘价乘以系数再加上昨天EMA乘以系数-1
                ema = sources.get(i).doubleValue() * k + ema * (1 - k);
                result[i] = ema;
            }
            return new ArrayList(Arrays.asList(result));
        };
    }

    public void setCalculTreatValueFunc(Function<IStockFrame, Number> calculTreatValueFunc) {
        this.calculTreatValueFunc = calculTreatValueFunc;
    }
}
