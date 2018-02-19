package com.rvfs.challenge.stocksmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvfs.challenge.stocksmanager.domain.Stock;
import com.rvfs.challenge.stocksmanager.repository.StockRepository;

/**
 * Stock Services implementation.
 * 
 * @author rodrigovfsilva
 *
 */
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository repository;

	@Override
	public Stock create(Stock stock) {
		return repository.save(stock);
	}

	@Override
	public Stock update(Stock stock) {
		return repository.save(stock);
	}

	@Override
	public List<Stock> getAll() {
		return repository.findAll();
	}

	@Override
	public Stock findById(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
