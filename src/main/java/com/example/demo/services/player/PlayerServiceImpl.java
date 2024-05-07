package com.example.demo.services.player;

import com.example.demo.DTO.FormDto;
import com.example.demo.DTO.PlayerResponseDto;
import com.example.demo.DTO.SearchDto;
import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import com.example.demo.repositories.ClubRepository;
import com.example.demo.repositories.PlayerRepository;
import com.example.demo.services.cloudinary.CloudinaryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PlayerServiceImpl implements  PlayerService{
    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;
    private final CloudinaryService cloudinaryService;

    private final ModelMapper modelMapper;

    @Override
    public Player addPlayer(FormDto formDto) {

        Player player = modelMapper.map(formDto, Player.class);
        String playerImage = cloudinaryService.uploadFile(formDto.getImagePlayer());
        System.out.println(playerImage);
        String profileImage = cloudinaryService.uploadFile(formDto.getImageProfile());
        String logoImage = cloudinaryService.uploadFile(formDto.getLogo());

        Club club = modelMapper.map(formDto, Club.class);
        club.setLogo(logoImage);
        club.setName(formDto.getClubName());
        clubRepository.save(club);
        player.setClub(club);
        player.setImagePlayer(playerImage);
        player.setImageProfile(profileImage);
        return playerRepository.save(player);
    }
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    @Override
    public Optional<PlayerResponseDto> getPlayerById(Integer id){
        return  playerRepository.findById(id).map(player -> modelMapper.map(player, PlayerResponseDto.class));
    }
    @Override
    public List<Player> searchPlayer(SearchDto name){
        String nm = name.getName();
        return playerRepository.findPlayerByNameLikeIgnoreCase(nm).stream().map(player -> modelMapper.map(player, Player.class)).toList();
    }

}
