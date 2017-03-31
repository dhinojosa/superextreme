package com.xyzcorp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class StockReport {

	private StockService stockService;

	public StockReport(StockService stockService) {
		this.stockService = stockService;
	}

	public Optional<LocalDate> getDateOfHighestValue(LocalDate start, LocalDate end) {
		return Optional.empty();
	}

}
