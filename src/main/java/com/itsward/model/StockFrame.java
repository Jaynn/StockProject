package com.itsward.model;

import com.itsward.constant.IStockFrame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StockFrame implements IStockFrame {
    private LocalDate date;
    private double open;
    private double close;
    private double high;
    private double low;
    private long volume;

    public StockFrame() {
    }

    public StockFrame(String[] fields, DateTimeFormatter formatter) {
        int i = 0;
        this.date = LocalDate.parse(fields[i++], formatter);
        this.open = Double.parseDouble(fields[i++]);
        this.close = Double.parseDouble(fields[i++]);
        this.high = Double.parseDouble(fields[i++]);
        this.low = Double.parseDouble(fields[i++]);
        this.volume = Long.parseLong(fields[i++]);
    }


    public StockFrame(LocalDate date, double open, double close, double high, double low, long volume) {
        this.date = date;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    @Override
    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Override
    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    @Override
    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    @Override
    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }
}
