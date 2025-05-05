package com.example.tasktracker.repository;

import com.example.tasktracker.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}