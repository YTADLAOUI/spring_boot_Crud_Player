package com.example.demo.services.player;

import com.example.demo.DTO.FormDto;
import com.example.demo.DTO.PlayerResponseDto;
import com.example.demo.DTO.SearchDto;
import com.example.demo.entities.Player;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlayerService {
    Player addPlayer(FormDto formDto);
    List<Player> getAllPlayers();
    Optional<PlayerResponseDto> getPlayerById(Integer id);
    List<Player> searchPlayer(SearchDto name);
}
