package com.capgemini.dad.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.dad.entity.ProductOrder;

public interface TrackProductOrderDao extends JpaRepository<ProductOrder, Long>{

}
