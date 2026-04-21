package com.football.model.game;

import com.football.model.record.MatchResult;
import com.football.interfaces.IPlayable;
import com.football.model.entity.Team;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Match extends Game implements IPlayable {
    private static final Logger LOGGER = LogManager.getLogger(Match.class);

    public Match(Team teamA, Team teamB) {
        super(teamA, teamB);
    }

    @Override
    public void play() {
        MatchResult<Team> result = playMatch();

        if (result != null) {
            LOGGER.info("Winner: {}", result.winner().getName());
        } else {
            LOGGER.info("Match ended in a draw");
        }
    }

    public MatchResult<Team> playMatch() {
        if (teamA.getPower() > teamB.getPower()) {
            return new MatchResult<>(teamA);
        } else if (teamB.getPower() > teamA.getPower()) {
            return new MatchResult<>(teamB);
        }
        return null;
    }
}
