package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postIndex(Model model){
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("title", "Post Index");
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}")
    public String post(@PathVariable Long id, Model model){
        model.addAttribute("title", "Individual Post");
        model.addAttribute("post", postDao.findById(id));
        Optional<Post> postAsOpt = postDao.findById(id);
        Post post = postAsOpt.get();
        System.out.println("post1.getTitle() = " + post.getTitle());
        model.addAttribute("postTitle", post.getTitle());
        model.addAttribute("postBody", post.getBody());
        return "posts/show";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String getCreate(){
        return "This will pull the create a post page.";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String postCreate(){
        return "This will post the create a post page.";
    }
}