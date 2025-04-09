package com.tsg.tsg_dashboard.match;


import com.tsg.tsg_dashboard.player.playerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class matchService {

    private final matchRepository matchRepository;
    private final playerRepository playerRepository;

    @Autowired
    public matchService(matchRepository matchRepository, playerRepository playerRepository) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    public List<match> getMatches() {
        return matchRepository.findAll();
    }

    public List<match> getMatchByOpponent(String opponent) {
        return matchRepository.findAll().stream()
                .filter(match -> match.getOpponent().toLowerCase().contains(opponent.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<match> getMatchByCourt(String court) {
        return matchRepository.findAll().stream()
                .filter(match -> match.getCourt_location().toLowerCase().contains(court.toLowerCase()))
                .collect(Collectors.toList());
    }

    public match addMatch(match match) {
        return matchRepository.save(match);
    }

    public match updateMatch(match match) {
        Optional<match> existingMatch = matchRepository.findByMatch_id(match.getMatch_id());

        if (existingMatch.isPresent()) {
            match matchToUpdate = existingMatch.get();
            matchToUpdate.setOpponent(match.getOpponent());
            matchToUpdate.setCourt_location(match.getCourt_location());
            matchToUpdate.setTsg_score(match.getTsg_score());
            matchToUpdate.setOpp_score(match.getOpp_score());

            matchRepository.save(matchToUpdate);
            return matchToUpdate;
        }
        return null;
    }

    public void deleteMatch(int match_id) {
        matchRepository.deleteByID(match_id);
    }
}
