package org.example.statistics;

import org.example.myException.WrongSportException;
import org.example.player.Player;
import org.example.player.PlayerBasketball;
import org.example.player.PlayerHandball;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MatchStatTest {

    @Test
    public void getPlayers() throws WrongSportException {
        MatchStat matchStat = new MatchStat();

        String[] basketballMatch = {"BASKETBALL\n" +
                "player 1;nick1;4;Team A;10;2;7\n" +
                "player 2;nick2;8;Team A;0;10;0\n" +
                "player 3;nick3;15;Team A;15;10;4\n" +
                "player 4;nick4;16;Team B;20;0;0\n" +
                "player 5;nick5;23;Team B;4;7;7\n" +
                "player 6;nick6;42;Team B;8;10;0"};
        List<List<Player>> actualBasketball = matchStat.getPlayers(basketballMatch);
        List<List<Player>> expectedBasketball = new ArrayList<>();
        List<Player> playersBasketball = new ArrayList<>();
        playersBasketball.add(new PlayerBasketball("player 1", "nick1", 4, "Team A", 10, 2, 7));
        playersBasketball.add(new PlayerBasketball("player 2", "nick2", 8, "Team A", 0, 10, 0));
        playersBasketball.add(new PlayerBasketball("player 3", "nick3", 15, "Team A", 15, 10, 4));
        playersBasketball.add(new PlayerBasketball("player 4", "nick4", 16, "Team B", 20, 0, 0));
        playersBasketball.add(new PlayerBasketball("player 5", "nick5", 23, "Team B", 4, 7, 7));
        playersBasketball.add(new PlayerBasketball("player 6", "nick6", 42, "Team B", 8, 10, 0));

        expectedBasketball.add(playersBasketball);
        assertEquals(actualBasketball, expectedBasketball);
    }
}