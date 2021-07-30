package thaovan.java6.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thaovan.java6.lab.entity.Roles;
import thaovan.java6.lab.repository.RolesRepository;

@Service
public class RoleService {

    @Autowired
    private RolesRepository rolesRepository;

    public Iterable<Roles> findAll() {
        return this.rolesRepository.findAll();
    }
}
