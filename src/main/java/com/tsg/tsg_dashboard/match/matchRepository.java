package com.tsg.tsg_dashboard.match;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface matchRepository extends JpaRepository<match, Long> {

    Optional<match> findByMatch_id(int match_id);

    @Modifying
    @Transactional
    @Query("DELETE FROM match m WHERE m.match_id = :match_id")
    void deleteByID(@Param("match_ID") int match_id);
}
