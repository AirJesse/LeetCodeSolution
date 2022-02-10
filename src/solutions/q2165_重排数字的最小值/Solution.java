package solutions.q2165_重排数字的最小值;

import java.util.*;

public class Solution {
    public long smallestNumber(long num) {
        List<Integer> numArray = getNumArray(num);
        Collections.sort(numArray);
        long result = 0;
        double pos = Math.pow(10,numArray.size() -1);
        if(num <0){
            for (int i = numArray.size()-1; i >=0; i--) {
                result += numArray.get(i) * pos;
                pos /=10;
            }
            return -result;
        }
        Queue<Integer> zeroQueue = new LinkedList<>();
        for (int i = 0; i < numArray.size(); i++) {
            if(numArray.get(i)== 0){
                zeroQueue.offer(0);
                continue;
            }
            result += numArray.get(i) * pos;
            pos /=10;
            while (!zeroQueue.isEmpty()){
                zeroQueue.poll();
                pos/=10;
            }
        }
        return result;
    }

    private List<Integer> getNumArray(long num) {
        long pos = 10;
        num = Math.abs(num);
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add((int) ((num % pos - num % (pos / 10)) / (pos /10)));
            if(num - num % pos == 0){
                break;
            }
            pos *= 10;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().smallestNumber(3260190823L));
    }
}
