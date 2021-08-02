package thaovan.lab8.repository;

import org.springframework.data.repository.CrudRepository;
import thaovan.lab8.entity.AccountsEntity;

public interface AccountsRepository extends CrudRepository<AccountsEntity, String> {
}