package com.tsg.tsg_dashboard.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class playerService {

    private final playerRepository playerRepository;

    @Autowired
    public playerService(playerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<player> getPlayerByName(String playerName) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(playerName.toLowerCase())).
                collect(Collectors.toList());
    }

    public player addPlayer(player player) {
        return playerRepository.save(player);
    }

    public player updatePlayer(player player) {
        Optional<player> existingPlayer = playerRepository.findByName(player.getName());

        if (existingPlayer.isPresent()) {
            player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(player.getName());
            playerToUpdate.setGamesPlayed(player.getGamesPlayed());
            playerToUpdate.setGoals(player.getGoals());
            playerToUpdate.setAssists(player.getAssists());
            playerToUpdate.setCleanSheets(player.getCleanSheets());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }

        return null;
    }

    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }


}
