package com.rvfs.challenge.stocksmanager.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@Autowired
	private StockService stockService;

	@RequestMapping()
	public List<Stock> getAll() {
		return stockService.getAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Stock>> listAllUsers() {
		List<Stock> stocks = stockService.getAll();
		if (stocks.isEmpty()) {
			return new ResponseEntity<List<Stock>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Stock>>(stocks, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Stock> getUser(@PathVariable("id") Integer id) {
		Stock stock = stockService.findById(id);
		if (stock == null) {
			return new ResponseEntity<Stock>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Stock>(stock, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody Stock stock) {
		Stock savedStock = stockService.create(stock);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedStock.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		stockService.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@RequestBody Stock stock, @PathVariable Integer id) {

		Stock studentOptional = stockService.findById(id);

		if (studentOptional == null)
			return ResponseEntity.notFound().build();

		stock.setId(id);

		stockService.update(stock);

		return ResponseEntity.noContent().build();
	}
}
