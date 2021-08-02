package thaovan.lab8.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import thaovan.lab8.entity.OrdersEntity;

import java.util.List;

public interface OrdersRepository extends CrudRepository<OrdersEntity,Long> {

    List<OrdersEntity> findByCustomer(String username);
}
