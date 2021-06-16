package com.pt15305ud.assignment.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pt15305ud.assignment.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {

}
