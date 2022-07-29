package org.example.statistics;

import org.example.myException.FormatFileException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReadStat {
    //returns statistics of all matches from files in the given path
    public String[] readStatFiles(String folder) throws FormatFileException {
        List<File> files = listFile(folder);
        String[] statMatch = new String[0];
        if (isCsvFormat(files)){
            statMatch = fileRead(files);
        }
        return statMatch;
    }

    //a list of files on a given path
    private List<File> listFile(String folder){
        List<File> filesInFolder;
        try {
            filesInFolder = Files.walk(Paths.get(folder))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filesInFolder;
    }

    //checking whether the files conform to the given format
    private boolean isCsvFormat(List<File> files) throws FormatFileException {
        for(File file:files){
            if (!getFileExtension(file).equals("csv"))
                throw new FormatFileException();
        }
        return true;
    }

    //returning the file format
    private String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    //reading statistics from a file
    private String[] fileRead(List<File> files) {
        String[] data = new String[files.size()];

        BufferedReader br = null;
        String line = "";

        for(int i = 0; i < files.size(); i++){
            data[i]="";
            try {
                br = new BufferedReader(new FileReader(files.get(i)));
                while ((line = br.readLine()) != null) {

                    data[i] += line + '\n';
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return data;
    }
}