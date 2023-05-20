package com.telco.operator.telcoservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telco.operator.telcoservices.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Integer> {

	@Query(value = "select se from Service se " + "inner join se.address ad" + " where(ad.addressId=:addressId) ")
	List<Service> findByAddressId(@Param("addressId") int addressId);
}
