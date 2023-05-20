package com.telco.operator.telcoservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.telco.operator.telcoservices.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	@Query(value = "select ad from Address ad " + " where(ad.addressId=:addressId) ")
	Address findByAddressId(@Param("addressId") int addressId);

	@Query(value = "select ad from Address ad "

			+ " where (:streetNo is null or :streetNo ='' or ad.streetNo like '%'||:streetNo ||'%') and "
			+ "  (:street is null or :street ='' or ad.street like '%'||(:street)||'%') and "
			+ "  (:city is null or :city ='' or ad.city like '%'||(:city)||'%') and "
			+ "  (:post is null or :post ='' or ad.post like '%'||(:post)||'%') and "
			+ " (:postNo is null or ad.postNo =:postNo) ")
	List<Address> findByAddressFilter(@Param("streetNo") String streetNo, @Param("street") String street,
			@Param("city") String city, @Param("post") String post, @Param("postNo") Integer postNo

	);
}
