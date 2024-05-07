package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imagePlayer;
    private String imageProfile;
    private String name;
    private  int age;
    private String position;
    private int height;
    private int weight;
    private int matches;
    private int buts;
    private int assists;

    @ManyToOne
    private Club club;

}
