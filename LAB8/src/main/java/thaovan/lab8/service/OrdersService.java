package thaovan.lab8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thaovan.lab8.entity.OrderDetailsEntity;
import thaovan.lab8.entity.OrdersEntity;
import thaovan.lab8.repository.OrdersRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersService {
	@Autowired
	private OrdersRepository ordersRepository;

	@Autowired
	private OrderDetailsService orderDetailsService;

	@Transactional
	public OrdersEntity save(OrdersEntity ordersEntity) {
		OrdersEntity order = this.ordersRepository.save(ordersEntity);

		order.getOrderDetailsEntities().forEach(x -> {
			x.setOrdersEntity(ordersEntity);
			this.orderDetailsService.save(x);
		});


		return order;
	}

	public List<OrdersEntity> findByUsername(String username) {
		return this.ordersRepository.findByCustomer(username);
	}

	public OrdersEntity findById(Long id) {
		return this.ordersRepository.findById(id).get();
	}
 }
