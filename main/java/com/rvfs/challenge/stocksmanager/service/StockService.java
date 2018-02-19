package com.rvfs.challenge.stocksmanager.service;

import java.util.List;

import com.rvfs.challenge.stocksmanager.domain.Stock;

/**
 * Stock Services interface.
 * 
 * @author rodrigovfsilva
 *
 */
public interface StockService {

	Stock create(Stock stock);

	Stock update(Stock stock);

	List<Stock> getAll();

	Stock findById(Integer id);

	void delete(Integer id);

}
