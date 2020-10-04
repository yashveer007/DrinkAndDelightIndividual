package com.capgemini.dad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.dad.entity.Distributor;

@Repository
public interface IDistributorDao extends JpaRepository<Distributor, Long>{
	
	

}
