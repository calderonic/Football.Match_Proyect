package com.football.generics;

import java.util.HashMap;
import java.util.Map;

public class StatTracker<T> {
    private final Map<T, Integer> stats;

    public StatTracker() {
        stats = new HashMap<>();
    }

    public void addStat(T entity) {
        stats.put(entity, stats.getOrDefault(entity, 0) + 1);
    }

    public int getStat(T entity) {
        return stats.getOrDefault(entity, 0);
    }
}
