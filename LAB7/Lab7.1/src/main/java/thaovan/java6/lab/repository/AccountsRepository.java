package thaovan.java6.lab.repository;

import org.springframework.data.repository.CrudRepository;
import thaovan.java6.lab.entity.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, String> {

}
