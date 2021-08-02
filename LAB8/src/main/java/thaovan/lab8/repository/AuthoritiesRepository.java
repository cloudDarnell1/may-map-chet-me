package thaovan.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import thaovan.lab8.entity.AuthoritiesEntity;

public interface AuthoritiesRepository extends CrudRepository<AuthoritiesEntity, Integer> {

}
