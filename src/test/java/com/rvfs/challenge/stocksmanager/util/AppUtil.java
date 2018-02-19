package com.rvfs.challenge.stocksmanager.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.rvfs.challenge.stocksmanager.domain.Stock;

public class AppUtil {

	private AppUtil() {
	}

	public static Stock createStock() {
		return new Stock(1, "APPL", new BigDecimal("100.50"), Calendar.getInstance());
	}

	public static List<Stock> listStocks() {
		List<Stock> stocks = new ArrayList<Stock>();

		stocks.add(new Stock(1, "APPL", new BigDecimal("100.50"), Calendar.getInstance()));
		stocks.add(new Stock(2, "GOOGL", new BigDecimal("98.86"), Calendar.getInstance()));
		stocks.add(new Stock(3, "FB", new BigDecimal("98.86"), Calendar.getInstance()));

		return stocks;
	}

}
