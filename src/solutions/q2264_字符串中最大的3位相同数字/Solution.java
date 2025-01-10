package solutions.q2264_字符串中最大的3位相同数字;

public class Solution {
    public String largestGoodInteger(String num) {
        Integer result = null;
        int left = 0;
        int right = 1;
        char a;
        char b;
        while (right < num.length()) {
            a = num.charAt(left);
            b = num.charAt(right);
            if (a == b) {
                if (right - left == 2) {
                    if (result == null) {
                        result = Integer.parseInt(String.valueOf(b)) * 111;
                    } else {
                        result = Math.max(result, Integer.parseInt(String.valueOf(b)) * 111);
                    }
                    left = right;
                }
            } else {
                left = right;
            }
            right++;
        }
        if (result == null) {
            return "";
        }
        return result == 0 ? "000" : String.valueOf(result);
    }
}
