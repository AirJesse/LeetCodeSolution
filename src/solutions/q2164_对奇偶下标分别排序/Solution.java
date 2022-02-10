package solutions.q2164_对奇偶下标分别排序;

import javax.naming.ldap.PagedResultsResponseControl;
import java.util.*;

public class Solution {
    public int[] sortEvenOdd(int[] nums) {
        List<Integer> numsA = new ArrayList<>(nums.length);
        List<Integer> numsB = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if(i % 2 == 0){
                numsA.add(nums[i]);
            }else{
                numsB.add(nums[i]);
            }
        }
        Collections.sort(numsA);
        numsB.sort(Comparator.reverseOrder());
        int[] result = new int[nums.length];
        int index = 0;
        for (int i = 0; i < Math.max(numsA.size(),numsB.size()); i++) {
            result[index++] = numsA.get(i);
            if(i == numsB.size()){
                break;
            }
            result[index++] = numsB.get(i);
        }
        return result;
    }

}
