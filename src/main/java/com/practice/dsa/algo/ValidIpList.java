package com.practice.dsa.algo;

import java.util.ArrayList;
import java.util.List;

public class ValidIpList {

    public static List<String> validIPAddresses(String string) {
        // Write your code here.
        if (string.length() < 4) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k + 1 < string.length(); k++) {
                    String str1 = string.substring(0, i + 1);
                    String str2 = string.substring(i + 1, j + 1);
                    String str3 = string.substring(j + 1, k + 1);
                    String str4 = string.substring(k + 1);
                    if (validate(str1) && validate(str2) && validate(str3) && validate(str4)) {
                        list.add(str1 + "." + str2 + "." + str3 + "." + str4);
                    }
                }
            }
        }

        return list;
    }

    private static boolean validate(String str) {
        if (str.isEmpty()) return false;
        if (Integer.parseInt(str) > -1 && Integer.parseInt(str) < 256) {
            if (str.length() > 1) {
                if (str.startsWith("0")) return false;
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        validIPAddresses("1921680");
    }
}
