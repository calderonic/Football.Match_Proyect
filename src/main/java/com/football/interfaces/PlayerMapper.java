package com.football.interfaces;

import com.football.model.person.Player;

@FunctionalInterface
public interface PlayerMapper<R> {
    R map(Player player);
}
