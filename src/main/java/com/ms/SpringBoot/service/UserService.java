package com.ms.SpringBoot.service;

import com.ms.SpringBoot.Model.User;

import java.util.List;

public interface UserService {

	public User findUserByEmail(String email);

	public void saveUser(User user);

	public  List<User> findAll();

    public User findUserById(int id);

    public void updateUser(String rola, User user);


}
