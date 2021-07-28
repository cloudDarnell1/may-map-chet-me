package thaovan.java6.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thaovan.java6.lab.entity.Authorities;
import thaovan.java6.lab.service.AuthoritiesService;

import java.util.Map;

@RestController
@RequestMapping("/api/authorities")
public class AuthoritiesController {

    @Autowired
    private AuthoritiesService authoritiesService;

    @PostMapping
    public Authorities add(@RequestBody Authorities authorities) {
        return this.authoritiesService.insert(authorities);
    }

    @DeleteMapping
    public Long delete(@RequestBody Authorities authorities) {
        return this.authoritiesService.delete(authorities);
    }
}
