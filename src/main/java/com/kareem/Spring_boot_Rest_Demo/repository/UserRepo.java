package com.kareem.Spring_boot_Rest_Demo.repository;

import com.kareem.Spring_boot_Rest_Demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
