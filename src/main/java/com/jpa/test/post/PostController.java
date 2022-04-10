package com.jpa.test.post;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/socialmedia/post")
public class PostController {

	private PostService postService;
	public PostController(PostService postService) {
		super();
		this.postService = postService;
	}

	@GetMapping("/posts")
	public List<Post> getAllPosts() {
		return postService.getAllPosts();
	}
	
	@PostMapping("/create")
	public ResponseEntity<Post> createPost(@RequestBody Post spost) {
		Post post = postService.createPost(spost);
		return ResponseEntity.ok(post);
	}
}
