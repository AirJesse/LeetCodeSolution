package solutions.q1414_和为K的最少斐波那契数字数目;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibArray = fibArray(k);
        int sum = 0;
        int result = 0;
        while (sum < k) {
            for (int i =0;i<fibArray.size();i++) {
                if (sum + fibArray.get(i) > k) {
                    continue;
                }
                sum += fibArray.get(i);
                result++;
                i--;
            }

        }
        return result;
    }

    public List<Integer> fibArray(int maxNum) {
        List<Integer> result = new ArrayList<>();
        int a = 1;
        int b = 1;
        if (maxNum == 1) {
            result.add(1);
        }
        while (b <= maxNum) {
            int fib = a + b;
            a = b;
            b = fib;
            result.add(a);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinFibonacciNumbers(5));
    }
}
