package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class StockReportTest {

    @Test
    public void testHighReportFromEmptyList() {
       StockService stockService = mock(StockService.class);
       when(stockService.getAllFromDate(
    		       LocalDate.of(2017,1,1),
               LocalDate.of(2017,1,1))).thenReturn(new ArrayList<Stock>());
       
       StockReport stockReport = new StockReport(stockService);
       Optional<LocalDate> highDate = 
    		   stockReport.getDateOfHighestValue(LocalDate.of(2017,  1,  1), 
    				                             LocalDate.of(2017, 1, 1));
       assertThat(highDate).isEmpty();
    }
}
