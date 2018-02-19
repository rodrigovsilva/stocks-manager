/**
 * 
 */
package com.rvfs.challenge.stocksmanager.domain;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * Stocks model.
 * 
 * @author rodrigovfsilva
 *
 */
@Entity
@Table(name = "stock")
public class Stock {

	@Id
	private Integer id;
	private String name;
	private BigDecimal currentPrice;
	private Calendar lastUpdate;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the currentPrice
	 */
	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	/**
	 * @param currentPrice
	 *            the currentPrice to set
	 */
	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	/**
	 * @return the lastUpdate
	 */
	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate
	 *            the lastUpdate to set
	 */
	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}