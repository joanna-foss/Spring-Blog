package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String allPosts(Model model){
        ArrayList<Post> all = new ArrayList<>(2);
        Post post1 = new Post("This is my 1st title.", 1, "This is the body text of my 1st post titled, This is my 1st title.");
        Post post2 = new Post("This is my 2nd title.", 2, "This is the body text of my 2nd post titled, This is my 2nd title.");
        all.add(post1);
        all.add(post2);
        model.addAttribute("title", "Posts");
        model.addAttribute("allPosts", all);
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String post(Model model){
        Post post1 = new Post("This is my 1st title.", 1, "This is the body text of my 1st post titled, This is my 1st title.");
        model.addAttribute("title", "Individual Post");
        model.addAttribute("postTitle", post1.getTitle());
        model.addAttribute("postBody", post1.getBody());
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