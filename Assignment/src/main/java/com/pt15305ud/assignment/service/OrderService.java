package com.pt15305ud.assignment.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pt15305ud.assignment.interfaces.OrderDetailsRepository;
import com.pt15305ud.assignment.interfaces.OrderRepository;
import com.pt15305ud.assignment.interfaces.ProductRepository;
import com.pt15305ud.assignment.model.OrderDetails;
import com.pt15305ud.assignment.model.Orders;
import com.pt15305ud.assignment.model.Product;

@Component
public class OrderService {

	@Autowired
	OrderRepository _odersRepo;

	@Autowired
	OrderDetailsRepository _orderDetailRepo;

	@Autowired
	ProductRepository _productRepo;

	@Transactional
	public Long newOrder(Orders orders) throws Exception {
		try {

			Long id = _odersRepo.save(orders).getId();

			orders.setId(id);

			for (OrderDetails orderDetails : orders.getOrderDetails()) {
				Product p = _productRepo.getById(orderDetails.getProductId());
				if (orderDetails.getQuantity() > p.getQuantity()) {
					throw new Exception(
							"Order thất bại. Mặt hàng id " + orderDetails.getProductId() + " đã không đủ cho hóa đơn.");
				} else {

					int left = p.getQuantity() - orderDetails.getQuantity();
					p.setQuantity(left);
					_productRepo.save(p);

					orderDetails.setOrderId(id);
					_orderDetailRepo.save(orderDetails);

				}
			}

			return id;
		} catch (Exception e) {
			throw new Exception("Order thất bại");

		}
	}
}
