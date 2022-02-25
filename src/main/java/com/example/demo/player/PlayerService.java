package com.example.demo.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public boolean addNewPlayer(Player player) {
        Optional<Player> playerOptional = playerRepository.findPlayerByUsername(player.getUsername());
        if (playerOptional.isPresent()){
            //throw new IllegalStateException("Username already exist");
            return false;
        }
        playerRepository.save(player);
        return true;
    }

    public void deletePlayer(Long playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("Player with id " + playerId + " does not exist");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(Long playerId, String username, String password) {
        Player player = playerRepository.findById(playerId).orElseThrow(() -> new IllegalStateException("Player with id " + playerId + " does not exist"));
        if (username != null && username.length() > 0 && !Objects.equals(player.getUsername(), username)) {
            Optional<Player> playerOptional = playerRepository.findPlayerByUsername(username);
            if(playerOptional.isPresent()){
                throw  new IllegalStateException("username already exist");
            }
            player.setUsername(username);
        }
        if (password != null && password.length() > 0 && !Objects.equals(player.getPassword(), password)) {
            player.setPassword(password);
        }
    }

}
