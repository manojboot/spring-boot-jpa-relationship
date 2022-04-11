package com.jpa.test.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.test.comment.Comment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PostService {

	private PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		super();
		this.postRepository = postRepository;
	}
	
	public List<Post> getAllPosts() {
	    return postRepository.findAll();
	 }
	
	public Post createPost(Post spost) {
		log.info("insdie create");
		Post post = new Post();
		post.setTitle(spost.getTitle());
		post.setDescription(spost.getDescription());
		post.setCreatedAt(spost.getCreatedAt());
		post.setUpdatedAt(spost.getUpdatedAt());
		Comment comment = new Comment();
		List<Comment> comments = new ArrayList<Comment>();
		for(Comment c : spost.getComments()) {
		comment.setContent(c.getContent());
		comment.setCreatedAt(c.getCreatedAt());
		comment.setUpdatedAt(c.getUpdatedAt());
		comments.add(c);
		}
		post.setComments(comments);
		log.info("end create");
	    return postRepository.save(post);
	 }
}
