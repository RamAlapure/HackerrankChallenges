package com.hackerrank.challenges;

import java.util.Comparator;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

public class SortingComparator implements Comparator<Player> {

    public int compare(Player a, Player b) {
        int compare = Integer.compare(b.score, a.score);
        return compare != 0 ? compare : a.name.compareTo(b.name);
    }

    private int compareLegacy(Player a, Player b) {
        if (a.score < b.score) return 1;
        else if (a.score > b.score) return -1;
        else return a.name.compareTo(b.name);
    }

    public void compareByComparator(Player a, Player b) {
        Comparator.comparing(Player::getScore).thenComparing(Player::getName).compare(a, b);
    }
}