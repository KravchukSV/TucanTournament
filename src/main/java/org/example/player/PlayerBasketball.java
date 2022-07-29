package org.example.player;

import java.util.Objects;

public class PlayerBasketball extends Player {
    private int scoredPoint;
    private int rebounds;
    private int assists;

    private static final int COEFFICIENT_SCORE_POINT = 2;
    private static final int COEFFICIENT_REBOUND = 1;
    private static final int COEFFICIENT_ASSIST = 1;
    public PlayerBasketball(String playerName, String nickname, int number, String teamName, int scoredPoint, int rebounds, int assists) {
        super(playerName, nickname, number, teamName);
        this.scoredPoint = scoredPoint;
        this.rebounds = rebounds;
        this.assists = assists;
    }

    public int ratingPoint(){
        return scoredPoint*COEFFICIENT_SCORE_POINT + rebounds*COEFFICIENT_REBOUND + assists*COEFFICIENT_ASSIST + super.ratingPoint();
    }

    public int pointMatch(){
        return scoredPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerBasketball)) return false;
        if (!super.equals(o)) return false;
        PlayerBasketball that = (PlayerBasketball) o;
        return super.equals(o) && scoredPoint == that.scoredPoint && rebounds == that.rebounds && assists == that.assists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scoredPoint, rebounds, assists);
    }
}