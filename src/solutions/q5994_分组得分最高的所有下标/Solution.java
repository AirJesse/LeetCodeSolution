package solutions.q5994_分组得分最高的所有下标;



public class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int right = k;
        int left = 0;
        while (right <= s.length()) {
            String sub = s.substring(left, right);
            if (hash(sub, power, modulo) == hashValue) {
                return sub;
            }
            left++;
            right++;
        }
        return null;
    }

    private int hash(String s, int power, int module) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += ((s.charAt(i) - 'a' + 1) * Math.pow(power, i));
        }
        return sum % module;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        String xmmhdakfursinye = solution.subStrHash("xmmhdakfursinye", 96, 45, 15, 21);
        System.out.println(xmmhdakfursinye);
    }
}
