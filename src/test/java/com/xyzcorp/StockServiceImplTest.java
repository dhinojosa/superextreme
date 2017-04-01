package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.data.Offset;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StockServiceImplTest {

	@Test

	public void testSimpleScript() {
		String data = "Date,Open,High,Low,Close,Volume,Adj Close\n"
				+ "2017-03-29,57.169998,57.849998,57.130001,57.540001,6915700,57.540001";
		Stream<String> stream = Arrays.stream(data.split("\n"));
		StockServiceImpl stockService = new StockServiceImpl(stream);
		List<? extends Stock> result = stockService.getAllFromDate(LocalDate.of(2017, 1, 1), LocalDate.of(2017, 4, 1));
		assertThat(result.get(0).getHigh()).isEqualTo(57.849998, Offset.offset(.01));
	}

	@Test
	@Category(value = IntegrationTest.class)
	public void testConnectWithARealWebService() throws IOException {
		URL url = new URL("http://ichart.finance.yahoo.com/table.csv?s=SBUX&a=00&b=01&c=2017");
		InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream());
		BufferedReader buff = new BufferedReader(reader);
		Stream<String> lines = buff.lines();
		StockServiceImpl stockService = new StockServiceImpl(lines);
		List<? extends Stock> stockServiceList = stockService.getAllFromDate(LocalDate.of(2017, 1, 1),
				LocalDate.of(2017, 1, 3));
		assertThat(stockServiceList.get(0).getHigh()).isEqualTo(58.2999, Offset.offset(.01));
	}
}
