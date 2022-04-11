package com.jpa.test.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
		@GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Column(name = "uuid", columnDefinition = "char(36)")
	    @Type(type = "org.hibernate.type.UUIDCharType")
		private UUID uuid;
		private String title;
		private String description;
		@Temporal(TemporalType.TIMESTAMP)
		private Date createdAt;
		@Temporal(TemporalType.TIMESTAMP)
		private Date updatedAt;
		@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	    @JoinColumn(name = "post_id", referencedColumnName = "uuid")
		private List<Comment> comments = new ArrayList<Comment>();
		
}
