package com.rank.assessment.bonginhlanhla.demo.casino;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.logging.Logger;

@Configuration
public class PlayerConfig {
    private static final Logger LOG = Logger.getLogger(PlayerConfig.class.getName());

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository playerRepository) {

        return args -> {
            /**
             *  I am not adding Player ID because it will be auto generated
             * */
            LOG.info("Start loading default/test players");
            Player player1 = new Player(
                    "Nhlanhla",
                    "@nhlanhla",
                    1000
            );
            LOG.info("Player 1 -> " + player1.toString());

            Player player2 = new Player(
                    "Zamambo",
                    "@zamambo",
                    500
            );
            LOG.info("Player 2 -> " + player2.toString());

            Player player3 = new Player(
                    "Bongi",
                    "@bongi",
                    500
            );
            LOG.info("Player 3 -> " + player3.toString());

            Player player4 = new Player(
                    "Thabani",
                    "@thabani",
                    500
            );
            LOG.info("Player 4 -> " + player4.toString());

            playerRepository.saveAll(
                    List.of(
                            player1,
                            player2,
                            player3,
                            player4
                    )
            );
            LOG.info("Finish loading test players");
        };
    }
}
