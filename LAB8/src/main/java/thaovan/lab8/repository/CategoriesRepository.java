package thaovan.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import thaovan.lab8.entity.CategoriesEntity;

public interface CategoriesRepository extends CrudRepository<CategoriesEntity,String> {

}
