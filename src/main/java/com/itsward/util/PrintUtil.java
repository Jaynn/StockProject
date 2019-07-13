package com.itsward.util;

import com.itsward.constant.IStock;
import com.itsward.constant.IStockFrame;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PrintUtil {
    private static final String DELIMITER = ";";
    public static String print(IStockFrame frame) {
        String[] list = new String[]{
                frame.getDate().format(DateTimeFormatter.ISO_DATE),
                String.valueOf(frame.getOpen()),
                String.valueOf(frame.getClose()),
                String.valueOf(frame.getHigh()),
                String.valueOf(frame.getLow()),
                String.valueOf(frame.getVolume())
        };
        String result = Arrays.asList(list).stream().collect(Collectors.joining(DELIMITER));
        System.out.println(result);
        return result;
    }

    public static List<String> print(IStock<IStockFrame> stock) {
        return stock.stream().map(PrintUtil::print).collect(Collectors.toList());
    }
}
