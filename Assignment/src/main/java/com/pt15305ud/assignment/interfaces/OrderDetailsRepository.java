package com.pt15305ud.assignment.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt15305ud.assignment.model.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{

}
