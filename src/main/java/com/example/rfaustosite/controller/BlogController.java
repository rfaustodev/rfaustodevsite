package com.example.rfaustosite.controller;

import com.example.rfaustosite.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {
    private List<Post> posts = new ArrayList<>();

    public BlogController() {
        posts.add(new Post(1L, "Primeiro Post", "Conteudo do primeiro post."));
        posts.add(new Post(2L, "Segundo Post", "Conteudo do segundo post."));
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        model.addAttribute("post", post);
        return "post";
    }
}