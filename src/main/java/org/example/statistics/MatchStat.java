package org.example.statistics;

import org.example.myException.WrongSportException;
import org.example.player.Player;
import org.example.player.PlayerBasketball;
import org.example.player.PlayerHandball;

import java.util.ArrayList;
import java.util.List;

public class MatchStat {

    //list of players of the match
    public List<List<Player>> getPlayers(String[] matchStat) throws WrongSportException {
        String[][] statPlayers = getStatPlayers(matchStat);
        List<List<Player>> players = new ArrayList<>();

        for(int i = 0; i < statPlayers.length; i++){
            List<Player> p = new ArrayList<>();
            for(int j = 1; j < statPlayers[i].length; j++){
                p.add(getPlayer(statPlayers[i][j], statPlayers[i][0]));
            }
            players.add(p);
        }

        return players;
    }

    private String[][] getStatPlayers(String[] matchStat){
        String[][] statPlayers = new String[matchStat.length][];
        for(int i = 0; i < matchStat.length; i++){
            statPlayers[i] = matchStat[i].split("\n");
        }
        return statPlayers;
    }

    //creation of the Player object
    private Player getPlayer(String stat, String sport) throws WrongSportException {
        String[] statPlayer = stat.split(";");
        switch (sport){
            case "BASKETBALL":
                return getPlayerBasketball(statPlayer);
            case "HANDBALL":
                return getPlayerHandball(statPlayer);
            default:
                throw new WrongSportException();
        }
    }

    private PlayerBasketball getPlayerBasketball(String[] statPlayer){
        return new PlayerBasketball(statPlayer[0], statPlayer[1], Integer.parseInt(statPlayer[2]), statPlayer[3],
                Integer.parseInt(statPlayer[4]), Integer.parseInt(statPlayer[5]), Integer.parseInt(statPlayer[6]));
    }

    private PlayerHandball getPlayerHandball(String[] statPlayer){
        return new PlayerHandball(statPlayer[0], statPlayer[1], Integer.parseInt(statPlayer[2]), statPlayer[3],
                Integer.parseInt(statPlayer[4]), Integer.parseInt(statPlayer[5]));
    }

}