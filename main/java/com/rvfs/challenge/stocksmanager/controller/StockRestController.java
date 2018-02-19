package com.rvfs.challenge.stocksmanager.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rvfs.challenge.stocksmanager.domain.Stock;
import com.rvfs.challenge.stocksmanager.service.StockService;

/**
 * Rest controller.
 * 
 * @author rodrigovfsilva
 *
 */
@RestController
@RequestMapping("/api/stocks")
public class StockRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockRestController.class);

	@Autowired
	private StockService stockService;

	@GetMapping
	public List<Stock> getAll() {
		LOGGER.debug("getting all stocks");

		return stockService.getAll();
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Stock stock) {
		LOGGER.debug("creating stock {}", stock);

		Stock savedStock = stockService.create(stock);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStock.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		LOGGER.debug("deleting stock by id {}", id);
		stockService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Stock stock, @PathVariable Integer id) {
		LOGGER.debug("updating stock by id {}", id);

		Stock studentOptional = stockService.findById(id);

		if (studentOptional == null)
			return ResponseEntity.notFound().build();

		stock.setId(id);

		stockService.update(stock);

		return ResponseEntity.noContent().build();
	}
}
