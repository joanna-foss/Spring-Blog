package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.relationships.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}