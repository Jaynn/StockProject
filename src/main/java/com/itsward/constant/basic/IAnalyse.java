package com.itsward.constant.basic;

import com.itsward.constant.IStockFrame;

import java.util.ArrayList;
import java.util.List;

public interface IAnalyse<T extends IStockFrame> extends List<T> {
    default Operation[] analyse(int index, List<IRule> rules, IIndicator... indicators) {
        Operation[] result = new Operation[rules.size()];
        //TODO generate Operation by translate rule one by one using index and indicators
        return result;
    }

    default List<Operation[]> analyse(List<IRule> rules, IIndicator... indicators) {
        List<Operation[]> result = new ArrayList<>();
        for (int i = 0; i < this.size(); i++) {
            result.add(this.analyse(i, rules, indicators));
        }
        return result;
    }
}
