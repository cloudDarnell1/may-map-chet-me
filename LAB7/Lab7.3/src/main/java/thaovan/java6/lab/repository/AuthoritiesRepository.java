package thaovan.java6.lab.repository;

import org.springframework.data.repository.CrudRepository;
import thaovan.java6.lab.entity.Authorities;

public interface AuthoritiesRepository extends CrudRepository<Authorities, Long> {

    Authorities findByUsernameAndRoleId(String username, String roleId);

}
