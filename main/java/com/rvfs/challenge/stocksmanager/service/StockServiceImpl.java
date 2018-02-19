package com.rvfs.challenge.stocksmanager.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);

	@Autowired
	private StockRepository repository;

	@Override
	@Transactional
	public Stock create(Stock stock) {
		LOGGER.debug("creating stock {}", stock);
		return repository.save(stock);
	}

	@Override
	@Transactional
	public Stock update(Stock stock) {
		LOGGER.debug("updating stock {}", stock);
		return repository.save(stock);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Stock> getAll() {
		LOGGER.debug("getting all stocks");
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Stock findById(Integer id) {
		LOGGER.debug("finding stock by id {}", id);
		return repository.findOne(id);
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		LOGGER.debug("deleting stock by id {}", id);
		repository.delete(id);
	}

}
