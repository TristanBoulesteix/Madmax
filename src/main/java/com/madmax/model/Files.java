package com.madmax.model;

import java.io.*;

public class Files {
    private final static Files INSTANCE = new Files();

    private Files() {
    }

    public static Files getInstance() {
        return INSTANCE;
    }

    public String getData(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public void setData(String path, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path), true));
            writer.write(data);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
