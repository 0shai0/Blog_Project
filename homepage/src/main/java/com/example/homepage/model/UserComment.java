package com.example.homepage.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserComment {
    @Id
    private int seq;
    private String userComment;
}
