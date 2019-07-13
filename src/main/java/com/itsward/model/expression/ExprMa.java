package com.itsward.model.expression;

import com.itsward.constant.IStockFrame;
import com.itsward.model._Expression;
import com.itsward.model.ExpressionGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExprMa extends _Expression {
    private static final String NAME_VALUE = "Moving Average";
    private static final String CODE_VALUE = "MA";
    private int n = 5;
    private Function<IStockFrame, Number> calculTreatValueFunc = IStockFrame::getClose;

    public ExprMa(ExpressionGroup expressionGroup) {
        super(NAME_VALUE, CODE_VALUE, expressionGroup);
    }

    public ExprMa(int n, ExpressionGroup expressionGroup) {
        super(NAME_VALUE, CODE_VALUE, expressionGroup);
        this.n = n;
    }

    public String getCode() {
        return CODE_VALUE + n;
    }

    @Override
    public Function<List<IStockFrame>, List> getExpFunc() {
        return s -> {
            List<Double> sources = s.stream().map(this.calculTreatValueFunc).map(Number::doubleValue).collect(Collectors.toList());
            Double[] result = new Double[sources.size()];
            int size = Math.min(n, sources.size());
            double sum = sources.subList(0, n).stream().reduce(0.0, Double::sum);
            result[n - 1] = sum / n;
            for (int i = n; i < sources.size(); i++) {
                sum = sum + sources.get(i) - sources.get(i - n);
                result[i] = sum / n;
            }
            return new ArrayList(Arrays.asList(result));
        };
    }
}
