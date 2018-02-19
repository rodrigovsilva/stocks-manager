package com.rvfs.challenge.stocksmanager.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rvfs.challenge.stocksmanager.service.StockService;

/**
 * Web Controller.
 * 
 * @author rodrigovfsilva
 *
 */
@Controller
public class StockController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

	@Autowired
	private StockService stockService;

	/**
	 * Initial mapping.
	 * 
	 * @param model
	 *            InjectedmMap of model objects.
	 * @return Map of model objects.
	 */
	@RequestMapping
	public String init(Map<String, Object> model) {
		LOGGER.debug("initializing controller...");
		model.put("stocks", stockService.getAll());
		return "index";
	}
}
