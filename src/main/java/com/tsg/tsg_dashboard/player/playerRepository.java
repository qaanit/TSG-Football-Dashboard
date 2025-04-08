package com.tsg.tsg_dashboard.player;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface playerRepository extends JpaRepository<player, String> {

    //void deleteByName(String playerName);


    @Modifying
    @Transactional
    @Query("DELETE FROM player p WHERE p.name = :playerName")
    void deleteByName(@Param("playerName") String playerName);

    Optional<player> findByName(String playerName);
}
