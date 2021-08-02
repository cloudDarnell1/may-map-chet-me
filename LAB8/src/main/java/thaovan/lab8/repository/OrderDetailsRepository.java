package thaovan.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import thaovan.lab8.entity.OrderDetailsEntity;

public interface OrderDetailsRepository extends CrudRepository<OrderDetailsEntity,Long> {

}
