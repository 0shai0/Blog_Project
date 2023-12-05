package com.example.homepage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.homepage.model.UserContent;
import java.util.List;


@Repository
public interface UserContentRepository extends JpaRepository<UserContent, Integer>{
    List<UserContent> findBySeq(int seq);
    UserContent findByTitle(String title);
    UserContent findBycontent(String content);
}
