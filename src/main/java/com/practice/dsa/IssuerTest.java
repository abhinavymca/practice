package com.practice.dsa;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IssuerTest {
    public static void main(String[] args) {
        StringBuilder sb= new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("/Volumes/Macintosh HD/Users/abhgarg6/Downloads/dummytext.txt")))){
                String s = reader.readLine();
                while(s!=null) {
                    sb.append(s);
                    s=reader.readLine();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }


//        System.out.println(sb.toString());
        System.out.println(sb.toString().getBytes(StandardCharsets.UTF_8).length/100);


    }
}
