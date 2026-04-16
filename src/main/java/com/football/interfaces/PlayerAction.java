package com.football.interfaces;

import com.football.model.person.Player;

@FunctionalInterface
public interface PlayerAction {
    void apply(Player player);
}
