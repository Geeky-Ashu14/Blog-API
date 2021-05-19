package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
	
	
    @Autowired
    private BlogRepository blogRepository;

    // get all blogs
    @GetMapping
    public List <Blog> getAllUsers() {
        return this.blogRepository.findAll();
    }

    // get blog by id
    @GetMapping("/{id}")
    public Blog getBlogById(@PathVariable(value = "id") long blogId) {
        return this.blogRepository.findById(blogId)
            .orElseThrow(() -> new ResourceNotFoundException("No Blog  with id :" + blogId));
    }

    // add a blog
    @PostMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return this.blogRepository.save(blog);
    }

    // update blog with given id
    @PutMapping("/{id}")
    public Blog updateBlog(@RequestBody Blog blog, @PathVariable("id") long blogId) {
        Blog existingBlog = this.blogRepository.findById(blogId)
            .orElseThrow(() -> new ResourceNotFoundException("No Blog with id :" + blogId));
        existingBlog.setTitle(blog.getTitle());
        existingBlog.setContent(blog.getContent());
     //   existingBlog.setComment(blog.getComment());
        return this.blogRepository.save(existingBlog);
    }

    // delete blog with given id
    @DeleteMapping("/{id}")
    public ResponseEntity < Blog > deleteBlog(@PathVariable("id") long blogId) {
        Blog existingBlog = this.blogRepository.findById(blogId)
            .orElseThrow(() -> new ResourceNotFoundException("No Blog with id :" + blogId));
        this.blogRepository.delete(existingBlog);
        return ResponseEntity.ok().build();
    }
	
	

}
