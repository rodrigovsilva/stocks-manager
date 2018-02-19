package com.rvfs.challenge.stocksmanager.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.rvfs.challenge.stocksmanager.domain.Stock;
import com.rvfs.challenge.stocksmanager.service.StockService;
import com.rvfs.challenge.stocksmanager.util.AppUtil;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StockRestController.class, secure = false)
public class StockRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StockService stockService;

	@Test
	public void findById() throws Exception {
		Mockito.when(stockService.findById(Mockito.anyInt())).thenReturn(AppUtil.createStock());

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/stocks/1").accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println(result.getResponse());
		Stock expected = new Gson().fromJson("{\"id\":1, \"name\":\"APPL\"}", Stock.class);
		Stock found = new Gson().fromJson(result.getResponse().getContentAsString(), Stock.class);

		Assert.assertEquals(expected.getId(), found.getId());

	}

}
