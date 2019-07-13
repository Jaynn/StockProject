package com.itsward.model.expression;

import com.itsward.constant.IStockFrame;
import com.itsward.model._Expression;
import com.itsward.model.ExpressionGroup;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExprPrint extends _Expression {
    public ExprPrint() {
        super("PrintOut", "P0");
    }

    public ExprPrint(ExpressionGroup expressionGroup) {
        super("PrintOut", "P0", expressionGroup);
    }

    @Override
    public Function<List<IStockFrame>, List> getExpFunc() {
        return s -> s.stream().map(IStockFrame::getOpen).collect(Collectors.toList());
    }
}
