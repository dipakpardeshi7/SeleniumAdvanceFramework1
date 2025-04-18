package com.thetestingacademy.utils;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertyReader {
    PropertyReader() {

    }

    public static String readKey(String key) {
        Properties p = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/resources/data.properties");
            p.load(fis);
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
            return null;
        }
        return p.getProperty(key);
    }
}
    /*public static String readKey(String key) throws Exception {
        FileInputStream fileInputStream = null;
        Properties p = null;
        try {
            fileInputStream = new FileInputStream(new File(System.getProperty("user.dir") + "/src/main/resources/data.properties"));
            p = new Properties();
            p.load(fileInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (Objects.nonNull(fileInputStream)) {
                fileInputStream.close();
            }
        }

        if (p.getProperty(key) == null) {
            throw new Exception(p.getProperty(key) + " not found!!");
        } else {
            return p.getProperty(key);
        }

    }
}
*/