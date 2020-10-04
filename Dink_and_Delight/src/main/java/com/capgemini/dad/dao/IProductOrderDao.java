package com.capgemini.dad.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.dad.entity.ProductOrder;

@Repository
public interface IProductOrderDao extends JpaRepository<ProductOrder, Long> {
	
	@Query(value="SELECT * from Product_Order po where po.distributor_Id=?1 and po.status=?2 and po.del_Date>=?3 and po.del_Date<=?4 ",nativeQuery = true)
	public List<ProductOrder> getProductOrder(Long distributorId,String deliveryStatus,LocalDate startDate,LocalDate endDate);


}
