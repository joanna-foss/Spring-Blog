package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.relationships.Post;
import com.codeup.springblog.controllers.relationships.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String postIndex(Model model){
        model.addAttribute("posts", postDao.findAll());
        model.addAttribute("title", "Post Index");
        return "posts/index";
    }

    @GetMapping(path = "/posts/{id}")
    public String viewPost(@PathVariable long id, Model model){
        model.addAttribute("title", "Individual Post");
        model.addAttribute("post", postDao.findById(id));
        Post post = postDao.getById(id);
        User user = userDao.getById(post.getUser().getId());
        model.addAttribute("postTitle", post.getTitle());
        model.addAttribute("postBody", post.getBody());
        model.addAttribute("postID", post.getId());
        model.addAttribute("user", user);
        return "posts/show";
    }

    @GetMapping(path = "/posts/edit/{id}")
    public String getEdit(@PathVariable long id, Model model){
        model.addAttribute("title", "Edit Post");
        Post post = postDao.getById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }

    @PostMapping(path = "/posts/edit/{id}")
    public String postEdit(@PathVariable long id, @RequestParam String title, @RequestParam String body){
        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping(path="/posts/delete/{id}")
    public String postDelete(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping(path = "/posts/create")
    public String getCreate(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping(path = "/posts/create")
    public String postCreate(@ModelAttribute Post post){
        post.setUser(userDao.getById((long) 1));
        postDao.save(post);
        return "redirect:/posts";
    }
}