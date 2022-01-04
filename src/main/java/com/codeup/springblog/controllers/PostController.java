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
    public String post(@PathVariable long id, Model model){
        model.addAttribute("title", "Individual Post");
        model.addAttribute("post", postDao.findById(id));
        Optional<Post> postAsOpt = postDao.findById(id);
        Post post = postAsOpt.get();
        model.addAttribute("postTitle", post.getTitle());
        model.addAttribute("postBody", post.getBody());
        model.addAttribute("postID", post.getId());
        return "posts/show";
    }

    @GetMapping(path = "/posts/edit/{id}")
    public String getEdit(@PathVariable long id, Model model){
        model.addAttribute("title", "Edit Post");
        Optional<Post> postAsOpt = postDao.findById(id);
        Post post = postAsOpt.get();
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping(path = "/posts/edit/{id}")
    public String postEdit(@PathVariable long id, @RequestParam String title, @RequestParam String body){
        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "posts/index";
    }

    @GetMapping(path="/posts/delete/{id}")
    public String postDelete(@PathVariable long id){
        postDao.deleteById(id);
        return "posts/index";
    }

    @GetMapping(path = "/posts/create")
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