package com.tsg.tsg_dashboard.player;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class playerController {

    private final playerService playerService;

    @Autowired
    public playerController(playerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<player> getPlayers(
            @RequestParam(required = false) String name){
        if (name != null){
            return playerService.getPlayerByName(name);
        }
        else{return playerService.getPlayers();}
    }

    @PostMapping
    public ResponseEntity<player> addPlayer(@RequestBody player player){
        player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<player> updatePlayer(@RequestBody player player){
        player resultPlayer = playerService.updatePlayer(player);
        if (resultPlayer != null){
            return new ResponseEntity<>(resultPlayer, HttpStatus.OK);
        }
        else{return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
    }

    @DeleteMapping("/{playerName}")
    public ResponseEntity<String> deletePlayer(@PathVariable String playerName){
        playerService.deletePlayer(playerName);
        return new ResponseEntity<>("player deleted!", HttpStatus.OK);
    }

}
