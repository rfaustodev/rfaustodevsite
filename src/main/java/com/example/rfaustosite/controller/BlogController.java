package com.example.rfaustosite.controller;

import com.example.rfaustosite.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import com.example.rfaustosite.service.MarkdownService;

@Controller
public class BlogController {
    private List<Post> posts = new ArrayList<>();
    private final MarkdownService markdownService;

    public BlogController(MarkdownService markdownService) {
        this.markdownService = markdownService;
        posts.add(new Post(1L, "Primeiro Post", "   ***\n         Conteudo do primeiro post."));
        posts.add(new Post(2L, "Segundo Post", "   ***\n         Conteudo do segundo post."));
    }


    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/post/{id}")
    public String viewPost(@PathVariable Long id, Model model) {
        Post post = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
        String htmlContent = markdownService.markdownToHtml(post.getContent());
        model.addAttribute("post", post);
        model.addAttribute("htmlContent", htmlContent);

        return "post";
    }
}