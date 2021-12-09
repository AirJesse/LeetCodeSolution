package solutions.q458_可怜的小猪;

public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int i = minutesToTest / minutesToDie;
        return (int) Math.ceil(Math.log(buckets) / Math.log(i));
    }

    public static void main(String[] args) {
        new Solution().poorPigs(4, 15, 15);
    }
}
