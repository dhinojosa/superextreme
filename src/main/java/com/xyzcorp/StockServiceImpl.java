package com.xyzcorp;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StockServiceImpl {
    private Stream<String> stream;

    public StockServiceImpl(Stream<String> stream) {
        this.stream = stream;
    }

    public List<? extends Stock> getAllFromDate(LocalDate start, LocalDate end) {
        return stream.skip(1)
                     .map(line -> line.split(","))
                     .map(arr -> new StockImpl(LocalDate.parse(arr[0]), Double.parseDouble(arr[2])))
                     .collect(Collectors.toList());
    }
}
