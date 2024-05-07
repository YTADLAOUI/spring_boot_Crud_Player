package com.example.demo.DTO;

import com.example.demo.entities.Club;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class PlayerResponseDto {
    private String name;
    private  int age;
    private String position;
    private int height;
    private int weight;
    private int matches;
    private int buts;
    private int assists;
    private String imagePlayer;
    private String imageProfile;
    // club
    private Club club;
}
