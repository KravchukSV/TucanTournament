package org.example;

import org.example.player.Player;

import java.util.ArrayList;

public class Team {
    private String nameTeam;
    private ArrayList<Player> players = new ArrayList<>();

    //adding a player to the team
    public boolean addPlayer(Player player){
        if(players.size() == 0){
            nameTeam = player.getTeamName();
        }
        if(player.getTeamName().equals(this.nameTeam)){
            players.add(player);
            return true;
        }
        return false;
    }

    //calculation of team points for the match
    public int totalPoints(){
        int total = 0;
        for(Player player : players){
            total += player.pointMatch();
        }
        return total;
    }

    //checking whether the team won the match
    public boolean teamWinner(Team team){
        return this.totalPoints() > team.totalPoints();
    }

    //a note for the player about the team's victory
    public void pointsWin(){
        for(int i = 0; i < players.size(); i++){
            players.get(i).setTeamIsWin(true);
        }
    }
}