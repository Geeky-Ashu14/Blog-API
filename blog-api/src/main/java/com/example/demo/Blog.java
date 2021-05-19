package com.example.demo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="blogs")
public class Blog {

	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
       
	   
	    @Column(name = "blog_title",unique = true,length = 100,nullable=false)
	    private String title;

	    @Lob
	    @Column(name = "blog_content")
	    private String content;

	    @OneToMany(cascade = CascadeType.ALL,
	            fetch = FetchType.LAZY,
	            mappedBy = "blog")
	    private List<Comment> comments = new ArrayList<>();

	    
	    
		public Blog() {
			super();
		}



		public Blog(long id, String title, String content, ArrayList<Comment> comments) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.comments = comments;
		}



		public long getId() {
			return id;
		}



		public void setId(long id) {
			this.id = id;
		}



		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public String getContent() {
			return content;
		}



		public void setContent(String content) {
			this.content = content;
		}



		public List<Comment> getComments() {
			return comments;
		}



		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}



	    
	
	
}
