package thaovan.lab8.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import thaovan.lab8.entity.AccountsEntity;
import thaovan.lab8.repository.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AccountsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AccountsRepository accountsRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AccountsEntity accountsEntity =
				this.accountsRepository.findById(username).orElseThrow(() -> {
					throw new UsernameNotFoundException("not found "+username);
				});

		String[] roles = accountsEntity
				.getRolesEntities().stream()
				.map(role -> role.getName())
				.collect(Collectors.toList())
				.toArray(new String[0]);

		return User
			.withUsername(accountsEntity.getUsername())
				.password(passwordEncoder.encode(accountsEntity.getPassword()))
				.roles(roles).build();
	}

 }
