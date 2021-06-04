package com.pt15305.lab.lab34;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.name like %:name% or p.gearType = :gearType")
	List<Product> findByNameOrGearType(@Param("name") String name, @Param("gearType") GearTypes gearType);

	@Query("select p from Product p where p.name like %:name% and p.gearType = :gearType")
	List<Product> findByNameAndGearType(@Param("name") String name, @Param("gearType") GearTypes gearType);

	@Query("select p from Product p where p.gearType = :gearType")
	List<Product> findByGearType(@Param("gearType") GearTypes gearType);

	@Query("select p from Product p where p.name like %:name%")
	List<Product> findByNameLike(@Param("name") String name);

	Page<Product> findAll(Pageable page);
}
