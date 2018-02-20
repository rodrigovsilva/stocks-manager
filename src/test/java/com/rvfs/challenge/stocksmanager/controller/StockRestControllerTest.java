package com.rvfs.challenge.stocksmanager.controller;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rvfs.challenge.stocksmanager.domain.Stock;
import com.rvfs.challenge.stocksmanager.service.StockService;
import com.rvfs.challenge.stocksmanager.util.AppUtil;
import com.rvfs.challenge.stocksmanager.util.gson.CalendarAdapter;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StockRestController.class, secure = false)
public class StockRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StockService stockService;

	/**
	 * initialize a gson with calendar adapter to parse json to object
	 */
	private Gson gson = new GsonBuilder().registerTypeAdapter(Calendar.class, new CalendarAdapter()).create();

	@Test
	public void findById() throws Exception {
		Mockito.when(stockService.findById(Mockito.anyInt())).thenReturn(AppUtil.createStock());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/stocks/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());

		Stock expected = gson.fromJson(
				"{\"id\": 1,\"name\": \"APPL\",\"currentPrice\": 55.67,\"lastUpdate\": \"2018-02-19T21:42:39.001-03:00\"}",
				Stock.class);

		Stock found = gson.fromJson(result.getResponse().getContentAsString(), Stock.class);

		assertEquals(expected.getId(), found.getId());

	}

	@Test
	public void getAll() throws Exception {
		Mockito.when(stockService.getAll()).thenReturn(AppUtil.listStocks());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/stocks").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		List<Stock> found = gson.fromJson(result.getResponse().getContentAsString(), List.class);

		assertEquals(3, found.size());

	}

	@Test
	public void create() throws Exception {

		Calendar calendar = Calendar.getInstance();
		calendar.set(2018, Calendar.FEBRUARY, 19, 22, 30, 45);

		Stock stock = new Stock(4, "CSCO", new BigDecimal("54.33"), calendar);

		String expected = "{\"id\": 4,\"name\": \"CSCO\",\"currentPrice\": 54.33,\"lastUpdate\": \"2018-02-19T22:30:45.000-03:00\"}";

		Mockito.when(stockService.create(Mockito.any(Stock.class))).thenReturn(stock);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/stocks").accept(MediaType.APPLICATION_JSON)
				.content(expected).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus());

		String location = response.getHeader(HttpHeaders.LOCATION);

		assertEquals("http://localhost/api/stocks/4", location);

	}

	@Test
	public void update() throws Exception {

		Mockito.when(stockService.findById(Mockito.anyInt())).thenReturn(AppUtil.createStock());

		Stock updatedStock = AppUtil.createStock();

		updatedStock.setCurrentPrice(new BigDecimal("102.22"));

		String expected = "{\"id\": 1,\"name\": \"APPL\",\"currentPrice\": 102.22,\"lastUpdate\": \"2018-02-19T22:30:45.000-03:00\"}";

		Stock expectedStock = gson.fromJson(
				"{\"id\": 1,\"name\": \"APPL\",\"currentPrice\": 102.22,\"lastUpdate\": \"2018-02-19T22:30:45.000-03:00\"}",
				Stock.class);

		Mockito.when(stockService.update(Mockito.any(Stock.class))).thenReturn(updatedStock);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/stocks/{id}", updatedStock.getId())
				.accept(MediaType.APPLICATION_JSON).content(expected).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.OK.value(), response.getStatus());

		assertEquals(expectedStock.getId(), updatedStock.getId());

		assertEquals(expectedStock.getCurrentPrice(), updatedStock.getCurrentPrice());

	}

}
