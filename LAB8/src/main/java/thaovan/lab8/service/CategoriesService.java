package thaovan.lab8.service;

import org.springframework.stereotype.Service;
import thaovan.lab8.entity.CategoriesEntity;
import thaovan.lab8.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;

	public Iterable<CategoriesEntity> findAll() {
		return this.categoriesRepository.findAll();
	}
}
