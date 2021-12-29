package com.icurety.nicknames;

import javax.naming.Name;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileHandler {

    private static String CONFIG_FILENAME = "players.txt";

    public static void load(File parentFolder) {
        File configFile = new File(parentFolder, CONFIG_FILENAME);
        Map<String, String> names = new HashMap<String, String>();
        if(configFile.exists())
        {
            List<String> lines = null;
            try {
                lines = Files.readAllLines(configFile.toPath());
                for(String line : lines) {
                    String uuid = line.substring(0, line.indexOf(' '));
                    String name = line.substring(uuid.length() + 1);
                    names.put(uuid, name);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            NameRegistry.loadNames(names);
        }
    }

    public static void save(File parentFolder) {
        File configFile = new File(parentFolder, CONFIG_FILENAME);
        if(parentFolder.exists() == false)
            parentFolder.mkdirs();


        Map<String, String> names = NameRegistry.getNames();

        String output = "";

        for(String uuid : names.keySet()) {
            output += uuid + " " + names.get(uuid);
        }

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(configFile));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
