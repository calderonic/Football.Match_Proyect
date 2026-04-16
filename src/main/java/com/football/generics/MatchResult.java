package com.football.generics;

public class MatchResult<T> {
    private final T winner;

    public MatchResult(T winner) {
        this.winner = winner;
    }

    public T getWinner() {
        return winner;
    }
}
