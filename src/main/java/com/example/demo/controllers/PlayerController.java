package com.example.demo.controllers;


import com.example.demo.DTO.FormDto;
import com.example.demo.DTO.PlayerResponseDto;
import com.example.demo.DTO.SearchDto;
import com.example.demo.entities.Player;
import com.example.demo.services.player.PlayerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player")
@RequiredArgsConstructor
public class PlayerController {
    private final PlayerService playerService;
    @PostMapping("/add")
        public Player addPlayer(@ModelAttribute FormDto player) {
        System.out.println(player);
       return playerService.addPlayer(player);

    }

    @GetMapping("")
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Optional<PlayerResponseDto>  getPlayer(@PathVariable Integer id){
        return playerService.getPlayerById(id);
    }

    @PostMapping("/search")
    public List<Player> searchPlayer(@RequestBody SearchDto name){
        return playerService.searchPlayer(name);
    }



}
