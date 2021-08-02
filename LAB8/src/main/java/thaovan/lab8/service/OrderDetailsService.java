package thaovan.lab8.service;

import org.springframework.stereotype.Service;
import thaovan.lab8.entity.OrderDetailsEntity;
import thaovan.lab8.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class OrderDetailsService {

	@Autowired
	private OrderDetailsRepository orderDetailsRepository;

	public void save(OrderDetailsEntity orderDetailsEntity) {
		this.orderDetailsRepository.save(orderDetailsEntity);
	}
 }
