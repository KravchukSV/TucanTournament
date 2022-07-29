package org.example.player;

import java.util.Objects;

public class PlayerHandball extends Player {
    private int goalsMade;
    private int goalsReceived;
    private static final int COEFFICIENT_GOAL_MADE = 2;
    private static final int COEFFICIENT_GOAL_RECEIVED = -1;

    public PlayerHandball(String playerName, String nickname, int number, String teamName, int goalsMade, int goalsReceived) {
        super(playerName, nickname, number, teamName);
        this.goalsMade = goalsMade;
        this.goalsReceived = goalsReceived;
    }

    public int ratingPoint(){
        return goalsMade*COEFFICIENT_GOAL_MADE + goalsReceived*COEFFICIENT_GOAL_RECEIVED + super.ratingPoint();
    }

    public int pointMatch(){
        return goalsMade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerHandball)) return false;
        if (!super.equals(o)) return false;
        PlayerHandball that = (PlayerHandball) o;
        return super.equals(o) && goalsMade == that.goalsMade && goalsReceived == that.goalsReceived;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), goalsMade, goalsReceived);
    }
}