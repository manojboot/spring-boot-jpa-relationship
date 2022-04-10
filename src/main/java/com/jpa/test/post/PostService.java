package com.jpa.test.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jpa.test.comment.Comment;

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
	
	public Post createPost(Post post) {
		//Post post = new Post();
		post.setTitle(post.getTitle());
		post.setDescription(post.getDescription());
		post.setCreatedAt(post.getCreatedAt());
		post.setUpdatedAt(post.getUpdatedAt());
		Comment comment = new Comment();
		comment.setContent(post.getComments().get(0).getContent());
		comment.setCreatedAt(post.getComments().get(0).getCreatedAt());
		comment.setUpdatedAt(post.getComments().get(0).getUpdatedAt());
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(comment);
		post.setComments(comments);
	    return postRepository.save(post);
	 }
}
