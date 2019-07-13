package com.itsward.constant;

import java.time.LocalDate;

public interface IStockFrame {
    LocalDate getDate();
    double getOpen();
    double getClose();
    double getHigh();
    double getLow();
    long getVolume();
}
