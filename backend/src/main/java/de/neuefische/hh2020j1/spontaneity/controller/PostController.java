package de.neuefische.hh2020j1.spontaneity.controller;


import de.neuefische.hh2020j1.spontaneity.dto.AddPostDto;
import de.neuefische.hh2020j1.spontaneity.dto.SendPostDto;
import de.neuefische.hh2020j1.spontaneity.model.Post;
import de.neuefische.hh2020j1.spontaneity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<SendPostDto> getPostsSortedWithoutUsersPosts(Principal principal){
        return postService.getPostsSortedByTimeWithoutUsersPosts(principal.getName());
    }

    @GetMapping("myposts")
    public List<SendPostDto> getPostsOfUser(Principal principal){
        return postService.getPostsOfUser(principal.getName());
    }

    @PostMapping
    public Post addPost (@RequestBody AddPostDto dto, Principal principal){
        return postService.addPost(principal.getName(),dto);
    }
}
