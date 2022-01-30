package solutions.q884_两句话中的不常见单词;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> result = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                result.add(s);
            }
        }
        return result.toArray(new String[0]);


    }
}
