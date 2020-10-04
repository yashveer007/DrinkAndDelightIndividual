package com.capgemini.dad.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.dad.entity.Supplier;


@Repository
public interface ISupplierDao extends JpaRepository<Supplier, Long> {
	

}
