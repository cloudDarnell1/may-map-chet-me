package thaovan.lab8.service;

import org.springframework.stereotype.Service;
import thaovan.lab8.entity.ProductsEntity;
import thaovan.lab8.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;

	public Iterable<ProductsEntity> findByCategoryIdOrAll(Long categoryId) {
		return categoryId != null
				? this.productsRepository.findByCategoryId(categoryId)
				: this.productsRepository.findAll();
	}

	public ProductsEntity findById(Integer id) {
		return this.productsRepository.findById(id).get();
	}
 }
