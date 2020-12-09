package com.june.frame_okhttp;

import java.io.*;

public class FileUtils {
    public static String testCase;
    public static String readFile(String filePath, String charFormat){

        String str = "";
        try {
            FileInputStream fis = new FileInputStream(filePath);
            BufferedReader br = new java.io.BufferedReader(new InputStreamReader(fis));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            str = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
