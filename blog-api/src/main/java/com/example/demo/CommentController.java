package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/blogs")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/{id}/comments")
    public Page<Comment> getAllCommentsByBlogId(@PathVariable (value = "id") Long blogId,
                                                Pageable pageable) {
        return commentRepository.findByBlogId(blogId, pageable);
    }

    @PostMapping("/{id}/comments")
    public Comment createComment(@PathVariable (value = "id") Long blogId,
                                 @RequestBody Comment comment) {
        return blogRepository.findById(blogId).map(blog -> {
            comment.setBlog(blog);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("BlogId " + blogId + " not found"));
    }



}