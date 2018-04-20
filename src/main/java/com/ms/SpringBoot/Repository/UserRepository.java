package com.ms.SpringBoot.Repository;

import com.ms.SpringBoot.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

	public User findUserById(int id);

}
