package com.xyzcorp;

import java.time.LocalDate;
import java.util.Optional;

public class StockReport {

	private StockService stockService;

	public StockReport(StockService stockService) {
		this.stockService = stockService;
	}

	public Optional<LocalDate> getDateOfHighestValue(LocalDate start, LocalDate end) {
		stockService.getAllFromDate(start, end);
		return Optional.empty();
	}

}
