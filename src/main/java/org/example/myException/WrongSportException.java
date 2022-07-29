package org.example.myException;

public class WrongSportException extends Exception {
    @Override
    public String toString() {
        return "an unknown sport";
    }
}