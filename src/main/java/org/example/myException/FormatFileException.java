package org.example.myException;

public class FormatFileException extends Exception{
    @Override
    public String toString() {
        return "Incorrect file format";
    }
}