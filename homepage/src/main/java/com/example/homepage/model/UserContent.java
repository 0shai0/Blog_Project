package com.example.homepage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UserContent {
    @Id
    private int seq;
    private String title;
    private String content;
}
