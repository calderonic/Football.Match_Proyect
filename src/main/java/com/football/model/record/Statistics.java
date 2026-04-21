package com.football.model.record;

public record Statistics(int id, int matchesPlayed) {

    public Statistics {
        if (matchesPlayed < 0) {
            throw new IllegalArgumentException("matchesPlayed cannot be negative");
        }
    }
}
