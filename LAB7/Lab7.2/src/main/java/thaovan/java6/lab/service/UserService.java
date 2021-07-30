package thaovan.java6.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import thaovan.java6.lab.entity.Accounts;
import thaovan.java6.lab.repository.AccountsRepository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Accounts> accountOpt = accountsRepository.findById(username);

        Accounts account = accountOpt.orElseThrow( () -> {
            throw new UsernameNotFoundException(username + " not found in DB");
        });

        String[] roles = account.getRoles().stream()
                .map(role -> role.getId())
                .collect(Collectors.toList())
                .toArray(new String[0]);

        UserDetails userDetail = User.withUsername(account.getUsername())
                .password(passwordEncoder.encode(account.getPassword()))
                .roles(roles).build();
        return userDetail;
    }
}
