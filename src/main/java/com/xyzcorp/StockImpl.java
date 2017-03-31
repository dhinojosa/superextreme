package com.xyzcorp;

import java.time.LocalDate;

public class StockImpl implements Stock {
    private final LocalDate date;
    private final Double high;

    public StockImpl(LocalDate date, Double high) {
        this.date = date;
        this.high = high;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public double getHigh() {
        return high;
    }
}
