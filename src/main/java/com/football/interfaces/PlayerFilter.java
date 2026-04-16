package com.football.interfaces;

import com.football.model.person.Player;

@FunctionalInterface
public interface PlayerFilter {
    boolean test(Player player);
}
