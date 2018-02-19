package com.rvfs.challenge.stocksmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Stock Manager Application - Servlet Initializer.
 * 
 * @author rodrigovfsilva
 *
 */
@SpringBootApplication
public class StocksManagerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StocksManagerApplication.class, args);
	}

	@Override
	protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
		return application.sources(StocksManagerApplication.class);
	}
}
