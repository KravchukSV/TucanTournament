package org.example.statistics;

import org.example.myException.FormatFileException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReadStatTest {

    @Test
    public void readStatFiles() throws FormatFileException {
        ReadStat readStat = new ReadStat();
        String[] actual = readStat.readStatFiles("./src/test/res");
        String[] expected = {"BASKETBALL\n" +
                "player 1;nick1;4;Team A;10;2;7\n" +
                "player 2;nick2;8;Team A;0;10;0\n" +
                "player 3;nick3;15;Team A;15;10;4\n" +
                "player 4;nick4;16;Team B;20;0;0\n" +
                "player 5;nick5;23;Team B;4;7;7\n" +
                "player 6;nick6;42;Team B;8;10;0\n"};
        assertArrayEquals(actual, expected);
    }
}