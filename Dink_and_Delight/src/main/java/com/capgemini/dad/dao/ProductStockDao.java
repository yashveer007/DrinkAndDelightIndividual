package com.capgemini.dad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.dad.entity.ProductStock;

public interface ProductStockDao extends JpaRepository<ProductStock, Long> {

}
