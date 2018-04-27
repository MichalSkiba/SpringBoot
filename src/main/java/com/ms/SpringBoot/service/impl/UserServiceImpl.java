package com.ms.SpringBoot.service.impl;

import com.ms.SpringBoot.Model.Role;
import com.ms.SpringBoot.Model.User;
import com.ms.SpringBoot.Repository.RoleRepository;
import com.ms.SpringBoot.Repository.UserRepository;
import com.ms.SpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByLogin(String login) {
		return userRepository.findByLogin(login);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        
        Role userRole = roleRepository.findByRole("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        
		userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = null;
		userList = userRepository.findAll();
		return userList;
	}

	@Override
	public User findUserById(int id) {
		return userRepository.findUserById(id);
	}

	@Override
	public void updateUser(String rola, User user) {
		Role userRole = roleRepository.findByRole(rola);
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}
}
