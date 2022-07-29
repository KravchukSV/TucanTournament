package org.example;

import org.example.player.Player;

import java.util.*;

public class MVP {
    //finding the best player of the tournament
    public static HashMap<String, Integer> playersTucanTournament(List<List<Player>> playersList){
        bonusRatingTeam(playersList);
        HashMap<String, Integer> playersTucan = new HashMap<>();
        Player player;

        for(int i = 0; i < playersList.size(); i++){
            for(int j = 0; j < playersList.get(i).size(); j++){
                player = playersList.get(i).get(j);
                if(playersTucan.containsKey(player.getNickname())){
                    playersTucan.put(player.getNickname(),
                            player.ratingPoint()+playersTucan.get(player.getNickname()));
                }
                else
                    playersTucan.put(player.getNickname(), player.ratingPoint());
            }
        }
        return playersTucan;
    }

    //awarding bonus points for the team's victory
    private static void bonusRatingTeam(List<List<Player>> playersList){
        List<Team> teams;

        for(int i = 0; i < playersList.size(); i++){
            teams = new ArrayList<>();
            teams.add(new Team());

            for(int j = 0; j < playersList.get(i).size(); j++){
                boolean isAddPlayer = true;
                for(int k = 0; k < teams.size(); k++){
                    isAddPlayer = teams.get(k).addPlayer(playersList.get(i).get(j));
                }
                if(!isAddPlayer){
                    teams.add(new Team());
                    teams.get(teams.size()-1).addPlayer(playersList.get(i).get(j));
                }
            }

            Team teamWin = teams.get(0);
            for(int j = 1; j < teams.size(); j++){
                if(!teamWin.teamWinner(teams.get(j))){
                    teamWin = teams.get(j);
                }
            }
            teamWin.pointsWin();

        }
    }

    //return key by value
    private static String getKey(Map<String, Integer> players, Integer ratingPoint) {
        for (String k : players.keySet())
        {
            if (players.get(k).equals(ratingPoint) )  {
                return k;
            }
        }
        return null;
    }

    //output information about the best player
    public static void printMVP(HashMap<String, Integer> playersTucan){
        System.out.println("MVP:\n" + getKey(playersTucan, Collections.max(playersTucan.values())) +
                ", rating point - " + Collections.max(playersTucan.values()));
    }
}