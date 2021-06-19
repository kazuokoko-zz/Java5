package com.pt15305ud.assignment.service;

import java.util.List;

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
	public Orders newOrder(Orders orders) throws Exception {
		try {

			Long id = _odersRepo.save(orders).getId();

			orders.setId(id);
			List<OrderDetails> details = orders.getOrderDetails();
			for (int i = 0; i < details.size(); i++) {
				OrderDetails detail = details.get(i);
				Product p = _productRepo.getById(detail.getProductId());
				if (detail.getQuantity() > p.getQuantity()) {
					throw new Exception(
							"Order thất bại. Mặt hàng id " + detail.getProductId() + " đã không đủ cho hóa đơn.");
				} else {

					int left = p.getQuantity() - detail.getQuantity();
					p.setQuantity(left);
					_productRepo.save(p);
					
					
					detail.setOrderId(orders.getId());

					details.set(i, _orderDetailRepo.save(detail));

				}
			}
			orders.setOrderDetails(details);
			return orders;
		} catch (Exception e) {
			throw new Exception("Order thất bại");

		}
	}
}
