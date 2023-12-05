package com.example.homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.homepage.model.UserComment;


@Repository
public interface UserCommentRepository extends JpaRepository<UserComment, Integer> {
}
