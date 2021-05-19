package com.example.demo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByBlogId(Long postId, Pageable pageable);
   // Optional<Comment> findByIdAndPostId(Long id, Long postId);
}