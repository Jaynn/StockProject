package com.itsward.constant;

import com.itsward.constant.basic.IAnalyse;
import com.itsward.constant.basic.ICalculate;
import com.itsward.constant.basic.INameCode;

import java.util.List;

public interface IStock<T extends IStockFrame> extends List<T>, INameCode, ICalculate, IAnalyse<T> {
}
