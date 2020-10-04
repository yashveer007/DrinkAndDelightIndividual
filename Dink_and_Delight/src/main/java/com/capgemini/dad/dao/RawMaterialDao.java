package com.capgemini.dad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.dad.entity.RawMaterialOrder;

@Repository
public interface RawMaterialDao extends JpaRepository<RawMaterialOrder,Long>{

boolean existsByRmorderId(Long rmorderId);
	
	RawMaterialOrder findByRmorderId(Long rmorderId);
	
	

	

}
