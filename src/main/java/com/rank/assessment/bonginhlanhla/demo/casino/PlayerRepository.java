package com.rank.assessment.bonginhlanhla.demo.casino;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    Player findByUsername(String username);
}
