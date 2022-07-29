package org.example.player;

import java.util.Objects;

public class Player {
    private String playerName;
    private String nickname;
    private int number;
    private String teamName;
    private boolean teamIsWin;

    public Player(String playerName, String nickname, int number, String teamName) {
        this.playerName = playerName;
        this.nickname = nickname;
        this.number = number;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getNickname() {
        return nickname;
    }

    public int ratingPoint(){
        if(teamIsWin)
            return 10;
        return 0;
    }

    public int pointMatch(){
        return 0;
    }

    public void setTeamIsWin(boolean teamIsWin) {
        this.teamIsWin = teamIsWin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return number == player.number && teamIsWin == player.teamIsWin && playerName.equals(player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName, nickname, number, teamName);
    }
}