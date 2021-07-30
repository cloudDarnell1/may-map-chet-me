package thaovan.java6.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thaovan.java6.lab.entity.Authorities;
import thaovan.java6.lab.repository.AuthoritiesRepository;

import java.util.Map;

@Service
public class AuthoritiesService {

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    public Authorities findByAccountAndRole(Authorities authorities) {
        return this.authoritiesRepository.findByUsernameAndRoleId(authorities.getUsername(), authorities.getRoleId());
    }

    public Authorities insert(Authorities authorities) {
        authoritiesRepository.save(authorities);
        return authorities;
    }

    public Long delete(Authorities authorities) {
        Authorities byAccountAndRole = this.findByAccountAndRole(authorities);
        this.authoritiesRepository.deleteById(byAccountAndRole.getId());

        return authorities.getId();
    }
}
