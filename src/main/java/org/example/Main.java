package org.example;

import org.example.myException.FormatFileException;
import org.example.myException.WrongSportException;
import org.example.player.Player;
import org.example.statistics.MatchStat;
import org.example.statistics.ReadStat;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try {
            String folder = "./res"; //path to the file set
            ReadStat readStat = new ReadStat();
            MatchStat matchStat = new MatchStat();
            List<List<Player>> playersList = matchStat.getPlayers(readStat.readStatFiles(folder));
            HashMap<String, Integer> playersTucan = MVP.playersTucanTournament(playersList);
            MVP.printMVP(playersTucan);
        }catch (FormatFileException | WrongSportException e){
            System.out.println(e);
        }
    }
}