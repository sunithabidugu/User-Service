package com.obrs.repository;

import com.obrs.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    
	
	@Query("SELECT a FROM User a WHERE a.username=:username")
	User findByUsername(String username);
    // Add custom query methods if needed
}
