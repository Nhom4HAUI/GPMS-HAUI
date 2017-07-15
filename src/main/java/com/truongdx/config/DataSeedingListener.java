package com.truongdx.config;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.truongdx.domain.Role;
import com.truongdx.domain.User;
import com.truongdx.repository.RoleRepository;
import com.truongdx.repository.UserRepository;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// Roles
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			roleRepository.save(new Role("ROLE_ADMIN"));
		}

		if (roleRepository.findByName("ROLE_STUDENT") == null) {
			roleRepository.save(new Role("ROLE_STUDENT"));
		}

		if (roleRepository.findByName("ROLE_LECTURE") == null) {
			roleRepository.save(new Role("ROLE_LECTURE"));
		}

		// Admin account
		if (userRepository.findByUsername("admin@gmail.com") == null) {
			User admin = new User();
			admin.setUsername("admin@gmail.com");
			admin.setPassword(passwordEncoder.encode("123456"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_ADMIN"));
			roles.add(roleRepository.findByName("ROLE_LECTURE"));
			admin.setRoles(roles);
			userRepository.save(admin);
		}

		// Member account
		if (userRepository.findByUsername("student@gmail.com") == null) {
			User user = new User();
			user.setUsername("student@gmail.com");
			user.setPassword(passwordEncoder.encode("123456"));
			HashSet<Role> roles = new HashSet<>();
			roles.add(roleRepository.findByName("ROLE_STUDENT"));
			user.setRoles(roles);
			userRepository.save(user);
		}

	}

}
