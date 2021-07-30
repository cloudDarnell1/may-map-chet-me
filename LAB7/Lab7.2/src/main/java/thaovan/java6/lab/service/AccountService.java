package thaovan.java6.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thaovan.java6.lab.entity.Accounts;
import thaovan.java6.lab.repository.AccountsRepository;

@Service
public class AccountService {

    @Autowired
    private AccountsRepository accountsRepository;
    public Iterable<Accounts> findAll() {
        return accountsRepository.findAll();
    }
}
