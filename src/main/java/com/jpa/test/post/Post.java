package com.jpa.test.post;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.jpa.test.comment.Comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "post")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;
		private String title;
		private String description;
		private Date createdAt;
		private Date updatedAt;
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "post")
		private List<Comment> comments;
		
}
