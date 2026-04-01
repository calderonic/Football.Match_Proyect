package main.service;

import main.model.game.Match;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MatchService {
    private final Queue<Match> schedule = new LinkedList<>();
    private final Deque<Match> history = new ArrayDeque<>();

    public void addMatch(Match match) {
        schedule.add(match);
    }

        public void playNextMatch() {
        Match match = schedule.poll();

        if (match != null) {
            match.startGame();
            match.play();
            history.push(match);
        }
    }
}
