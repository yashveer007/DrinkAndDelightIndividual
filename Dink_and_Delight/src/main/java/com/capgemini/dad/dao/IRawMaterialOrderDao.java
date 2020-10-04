package com.capgemini.dad.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.dad.entity.RawMaterialOrder;

@Repository
public interface IRawMaterialOrderDao extends JpaRepository<RawMaterialOrder, Long>{
	
	@Query(value="SELECT * from Raw_Material_Order rm where rm.supplier_Id=?1 and"
			+ " rm.status=?2 and rm.del_Date>=?3 and rm.del_Date<=?4 ",nativeQuery = true)
	public List<RawMaterialOrder> getRawMaterialOrder(Long supplierId,String deliveryStatus,
			LocalDate startDate,LocalDate endDate);

}
