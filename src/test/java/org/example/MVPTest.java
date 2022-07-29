package org.example;

import org.example.player.Player;
import org.example.player.PlayerHandball;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class MVPTest {

    @Test
    public void playersTucanTournament() {
        List<List<Player>> expectedHandball = new ArrayList<>();
        List<Player> playersHandball = new ArrayList<>();
        playersHandball.add(new PlayerHandball("player 1", "nick1", 4, "Team A", 0, 20));
        playersHandball.add(new PlayerHandball("player 2", "nick2", 8, "Team A", 15, 20));
        playersHandball.add(new PlayerHandball("player 3", "nick3", 15, "Team A", 10, 20));
        playersHandball.add(new PlayerHandball("player 4", "nick4", 16, "Team B", 1, 25));
        playersHandball.add(new PlayerHandball("player 5", "nick5", 23, "Team B", 12, 25));
        playersHandball.add(new PlayerHandball("player 6", "nick6", 42, "Team B", 8, 25));

        expectedHandball.add(playersHandball);

        HashMap<String, Integer> actual = MVP.playersTucanTournament(expectedHandball);
        HashMap<String, Integer> expected = new HashMap<>();
        expected.put("nick1", -10);
        expected.put("nick2", 20);
        expected.put("nick3", 10);
        expected.put("nick4", -23);
        expected.put("nick5", -1);
        expected.put("nick6", -9);

        assertEquals(expected, actual);
    }
}