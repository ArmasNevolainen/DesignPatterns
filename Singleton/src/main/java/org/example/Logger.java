package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String currentFile;
    private static final String FILE= "log.txt";

    private Logger() {
        setFileName(FILE);
    }
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String fileName) {
        if (writer != null) {
            close();
        }
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
            currentFile = fileName;
        } catch (IOException e) {
            System.err.println("Failed to open log file: " + fileName);
            e.printStackTrace();
        }
    }

    public void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        }
    }

    public void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }

    public String getCurrentFileName() {
        return currentFile;
    }


}
