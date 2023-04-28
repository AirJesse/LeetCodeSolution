package leetCode_75.q1071_字符串的最大公因子;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String bigger = str1.length() >= str2.length() ? str1 : str2;
        String smaller = str1.length() < str2.length() ? str1 : str2;
        String result = smaller;

        while (bigger.startsWith(smaller)) {
            if(bigger.length() == smaller.length()){
                return bigger.equals(smaller)? result:"";
            }
            result = bigger.substring(smaller.length());
            if(result.length()<smaller.length()){
                bigger = smaller;
                smaller = result;
            }else{
                bigger = result;
            }

        }

        return "";
    }
    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().gcd(10,12));
    }
}
