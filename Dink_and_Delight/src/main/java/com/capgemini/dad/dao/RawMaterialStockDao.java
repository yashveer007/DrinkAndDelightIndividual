package com.capgemini.dad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.dad.entity.RawMaterialStock;

@Repository
public interface RawMaterialStockDao extends JpaRepository<RawMaterialStock, Long> {

	RawMaterialStock findByRmOrderId(Long orderId);

	RawMaterialStock findByRmOrderId(long orderId);
}
