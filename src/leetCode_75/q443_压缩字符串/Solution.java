package leetCode_75.q443_压缩字符串;

import java.sql.SQLOutput;

public class Solution {
    public int compress(char[] chars) {
        int len = 0;
        char c = chars[0];
        int n = 1;
        for (int i = 1; i <= chars.length; i++) {
            if (i != chars.length && chars[i] == c) {
                n++;
            } else {
                chars[len++] = c;
                if (n > 1) {
                    for (char nc : String.valueOf(n).toCharArray()) {
                        chars[len++] = nc;
                    }
                }
                if (i != chars.length) {
                    c = chars[i];
                    n = 1;
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
    }

}
