package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import java.lang.Math;


public class Main {
    public static void main(String[] args) {
        System.out.println("Example of levenshtein distance method: kot and kita distance is " + levQwerty("kot","kita"));
    }

    public static double levQwerty(String string1, String string2) {
        HashMap<String, List<String>> qwertyDictionary = new HashMap<>();
        fillDictionary(qwertyDictionary);

        String s1 = string1.toLowerCase().trim();
        String s2 = string2.toLowerCase().trim();

        double[][] distanceTable = new double[s1.length()+1][s2.length()+1];

        for(int i = 0; i<= s1.length(); i++) {
            distanceTable[i][0] = i;
        }
        for(int j = 1; j<= s2.length(); j++) {
            distanceTable[0][j] = j;
        }

        for(int i = 1; i<=s1.length(); i++) {
            for(int j = 1; j<=s2.length(); j++) {
                double costOfSubstitution;
                if(s1.charAt(i -1) == s2.charAt(j -1)) costOfSubstitution = 0;
                else if(keyIsNextTo(Character.toString(s1.charAt(i -1)), Character.toString(s2.charAt(j -1)), qwertyDictionary)) {
                    costOfSubstitution = 0.5;
                } else costOfSubstitution = 1;

                distanceTable[i][j] = Math.min(Math.min(distanceTable[i-1][j]+1,
                                            distanceTable[i][j-1]+1),
                                            distanceTable[i-1][j-1] + costOfSubstitution);
            }
        }

        return distanceTable[s1.length()][s2.length()];
    }

    public static boolean keyIsNextTo(String key1, String key2, HashMap<String, List<String>> dictionary) { //return true if key2 is next to key1
        List<String> values = dictionary.get(key1);
        for(String key : values){
            if(key.equals(key2)) return true;
        }
        return false;
    }

    public static void fillDictionary(HashMap<String, List<String>> myDictionary) {
        List<String> qValues = Arrays.asList("w");
        List<String> wValues = Arrays.asList("q", "e");
        List<String> eValues = Arrays.asList("w", "r");
        List<String> rValues = Arrays.asList("e", "t");
        List<String> tValues = Arrays.asList("r", "y");
        List<String> yValues = Arrays.asList("t", "u");
        List<String> uValues = Arrays.asList("y", "i");
        List<String> iValues = Arrays.asList("u", "o");
        List<String> oValues = Arrays.asList("i", "p");
        List<String> pValues = Arrays.asList("o");
        List<String> aValues = Arrays.asList("s");
        List<String> sValues = Arrays.asList("a", "d");
        List<String> dValues = Arrays.asList("s", "f");
        List<String> fValues = Arrays.asList("d", "g");
        List<String> gValues = Arrays.asList("f", "h");
        List<String> hValues = Arrays.asList("g", "j");
        List<String> jValues = Arrays.asList("h", "k");
        List<String> kValues = Arrays.asList("j", "l");
        List<String> lValues = Arrays.asList("k");
        List<String> zValues = Arrays.asList("x");
        List<String> xValues = Arrays.asList("z", "c");
        List<String> cValues = Arrays.asList("x", "v");
        List<String> vValues = Arrays.asList("c", "b");
        List<String> bValues = Arrays.asList("v", "n");
        List<String> nValues = Arrays.asList("b", "m");
        List<String> mValues = Arrays.asList("n");

        myDictionary.put("q", qValues);
        myDictionary.put("w", wValues);
        myDictionary.put("e", eValues);
        myDictionary.put("r", rValues);
        myDictionary.put("t", tValues);
        myDictionary.put("y", yValues);
        myDictionary.put("u", uValues);
        myDictionary.put("i", iValues);
        myDictionary.put("o", oValues);
        myDictionary.put("p", pValues);
        myDictionary.put("a", aValues);
        myDictionary.put("s", sValues);
        myDictionary.put("d", dValues);
        myDictionary.put("f", fValues);
        myDictionary.put("g", gValues);
        myDictionary.put("h", hValues);
        myDictionary.put("j", jValues);
        myDictionary.put("k", kValues);
        myDictionary.put("l", lValues);
        myDictionary.put("z", zValues);
        myDictionary.put("x", xValues);
        myDictionary.put("c", cValues);
        myDictionary.put("v", vValues);
        myDictionary.put("b", bValues);
        myDictionary.put("n", nValues);
        myDictionary.put("m", mValues);
    }
}
