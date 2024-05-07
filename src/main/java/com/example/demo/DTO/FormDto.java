package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class FormDto {
    private String name;
    private  int age;
    private String position;
    private int height;
    private int weight;
    private int matches;
    private int buts;
    private int assists;
    private MultipartFile imagePlayer;
    private MultipartFile imageProfile;
    // club
    private String clubName;
    private MultipartFile logo;
}
