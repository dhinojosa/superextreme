package com.xyzcorp;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class StockImplTest {


    private Stock stock;
    private LocalDate localDate;
    private double high;

    @Before
    public void setUp() {
        localDate = LocalDate.of(2017, 1, 10);
        high = 40.00;
        stock = new StockImpl(localDate, high);
    }

    @Test
    public void testLocalDate() throws Exception {
        assertThat(stock.getDate()).isEqualTo(localDate);
    }

    @Test
    public void testHigh() throws Exception {
        assertThat(stock.getHigh()).isEqualTo(high);
    }
}