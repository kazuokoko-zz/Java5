package com.pt15305ud.assignment.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pt15305ud.assignment.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("select p from Product p where p.active=:active")
	List<Product> findByActive(@Param("active") Boolean active);

	@Query("select p from Product p where p.active=:active")
	Page<Product> findByActive(Pageable page, @Param("active") Boolean active);

	@Query("select p from Product p where p.active=:active and p.name like %:name%")
	List<Product> findByActiveAndNameLike(@Param("active") Boolean active, @Param("name") String name);

	@Query("select p from Product p where p.active=:active and p.name like %:name%")
	Page<Product> findByActiveAndNameLike(Pageable page, @Param("active") Boolean active, @Param("name") String name);

	@Query("select p from Product p where  p.name like %:name%")
	List<Product> findByNameLike(@Param("name") String name);

	@Query("select p from Product p where  p.name like %:name%")
	Page<Product> findByNameLike(Pageable page, @Param("name") String name);

//	default Page<Product> findByActivePage(Pageable page) {
//		return findByActivePage(page, true);
//	}

//	@Query("select p from Product p where p.isDeleted=:isDeleted")
//	List<Product> findByIsDeleted(@Param("isDeleted") Boolean isDeleted);
//
//	Page<Product> findByIsDeletedPage(Pageable page, @Param("isDeleted") Boolean isDeleted);

}
