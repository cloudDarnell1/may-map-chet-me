package thaovan.lab8.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import thaovan.lab8.entity.ProductsEntity;

import java.util.List;

public interface ProductsRepository extends CrudRepository<ProductsEntity,Integer> {

    @Query(nativeQuery = true, value = "select * from products where category_id = :categoryId")
    Iterable<ProductsEntity> findByCategoryId(@Param("categoryId") Long categoryId);
}
