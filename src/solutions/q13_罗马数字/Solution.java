package solutions.q13_罗马数字;


import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Solution {
    Map<String, Integer> mapping = new HashMap<>(7);

    public int romanToInt(String s) {
        mapping.put("I", 1);
        mapping.put("V", 5);
        mapping.put("X", 10);
        mapping.put("L", 50);
        mapping.put("C", 100);
        mapping.put("D", 500);
        mapping.put("M", 1000);

        String[] chars = s.split("");

        return getInner(chars, 0);
    }

    private int getInner(String[] chars, int index) {
        String aChar = chars[index];
        if (chars.length - 1 == index) {
            return mapping.get(aChar);
        }
        String nextChar = chars[++index];
        if (aChar.equals("I") && "VX".contains(nextChar)
                || aChar.equals("X") && "LC".contains(nextChar)
                || aChar.equals("C") && "DM".contains(nextChar)) {
            return getInner(chars, index) - mapping.get(aChar);
        }

        return mapping.get(aChar) + getInner(chars, index);
    }



}
