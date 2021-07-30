package thaovan.java6.lab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
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

    public void loginFromOauth2(OAuth2AuthenticationToken oAuth2AuthenticationToken) {
        String username = (String) oAuth2AuthenticationToken.getPrincipal().getAttribute("given_name");
        String password = "";

        UserDetails guest = User.withUsername(username).password(passwordEncoder.encode(password)).roles("GUEST").build();

        Authentication authentication = new UsernamePasswordAuthenticationToken(guest, null, guest.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
