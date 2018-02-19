package com.rvfs.challenge.stocksmanager.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rvfs.challenge.stocksmanager.domain.Stock;

/**
 * Stock repository interface.
 * 
 * @author rodrigovfsilva
 *
 */
@Repository
public interface StockRepository extends JpaRepository<Stock, Serializable> {

}