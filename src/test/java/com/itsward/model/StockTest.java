package com.itsward.model;

import com.alibaba.fastjson.JSON;
import com.itsward.constant.IStock;
import com.itsward.constant.basic.IExpression;
import com.itsward.constant.basic.IExpressionGroup;
import com.itsward.constant.basic.IIndicator;
import com.itsward.model.expression.ExprMa;
import com.itsward.util.PrintUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class StockTest {
    private IStock stock;
    private IExpression[] expressions;

    private Stock mockStock() {
        String[] data = {
        "190510 10.89 11.79 11.79 10.63 430574",
        "190513 11.60 11.77 11.94 11.52 274028",
        "190514 11.64 11.75 12.18 11.62 315613",
        "190515 11.85 11.98 12.05 11.72 281993",
        "190516 11.94 12.04 12.18 11.75 273891",
        "190517 12.47 11.83 12.70 11.80 442296",
        "190520 12.05 12.82 13.01 12.05 741795",
        "190521 12.47 12.71 12.83 12.17 533818",
        "190522 12.55 12.66 12.96 12.29 413649",
        "190523 12.50 12.43 12.85 12.20 336946",
        "190524 12.33 11.53 12.39 11.41 331286",
        "190527 11.75 12.47 12.66 11.58 431187",
        "190528 12.56 12.66 12.92 12.45 491354",
        "190529 12.67 12.92 13.28 12.67 579310",
        "190530 12.62 13.11 13.65 12.60 598412",
        "190531 13.05 13.90 14.35 12.99 916510",
        "190603 13.80 13.30 13.81 13.20 646315",
        "190604 13.23 13.13 13.44 12.87 419399",
        "190605 13.33 12.80 13.40 12.78 419671",
        "190606 12.61 12.20 12.66 12.10 387446"
        };
        Stock result = new Stock();
        //http://data.gtimg.cn/flashdata/hushen/latest/daily/sz002023.js?maxage=43201&visitDstTime=1
        result.setName("海特高新");
        result.setCode("002023");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        for (int i = 0; i < data.length; i++) {
            String[] fields = data[i].split("\\s");
            result.add(new StockFrame(fields, dateTimeFormatter));
        }
        return result;
    }

    private IExpression[] mockExpression() {
        List<IExpression> result = new ArrayList<>();

        ExpressionGroup eg = new ExpressionGroup("BE", "BaseExpression");
        //result.add(new ExprPrint(eg));
        result.add(new ExprMa(5, eg));
        result.add(new ExprMa(10, eg));
        result.add(new ExprMa(20, eg));
        return result.toArray(new IExpression[result.size()]);
    }

    @BeforeEach
    void setUp() {
        this.stock = this.mockStock();
        this.expressions = this.mockExpression();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculate() {
        Map<IExpressionGroup, IIndicator> map = this.stock.calculate(expressions);
        System.out.println(JSON.toJSON(map));
    }

    @Test
    void print() {
        PrintUtil.print(this.stock);
    }
}