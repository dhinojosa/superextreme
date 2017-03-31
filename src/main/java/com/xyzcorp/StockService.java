package com.xyzcorp;

import java.time.LocalDate;
import java.util.List;

public interface StockService {
    public List<Stock> getAllFromDate(LocalDate start, LocalDate end);
}
