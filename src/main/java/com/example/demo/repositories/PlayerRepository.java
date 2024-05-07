package com.example.demo.repositories;

import com.example.demo.DTO.SearchDto;
import com.example.demo.entities.Club;
import com.example.demo.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {

    // query the search for players by  name and ignore case
    @Query("SELECT p FROM Player p WHERE lower(p.name) LIKE lower(concat('%', :name, '%'))")
    List<Player> findPlayerByNameLikeIgnoreCase(String name);

}
