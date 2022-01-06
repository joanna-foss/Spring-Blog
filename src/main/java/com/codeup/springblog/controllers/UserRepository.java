package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.relationships.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}