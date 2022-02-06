package solutions.q1748_唯一元素的和;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int num : nums) {
            Integer i = map.getOrDefault(num, 0);
            if(i ==0){
                sum+=num;
            }else if(i == 1){
                sum -=num;
            }
            map.put(num,i+1);
        }
        return sum;
    }
}
