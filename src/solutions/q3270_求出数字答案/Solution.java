package solutions.q3270_求出数字答案;


public class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int[] num1Int = numToArray(num1);
        int[] num2Int = numToArray(num2);
        int[] num3Int = numToArray(num3);
        int result = 0;
        for (int i = 0; i < 4; i++) {
            int min = Math.min(num1Int[i], Math.min(num2Int[i], num3Int[i]));
            result += (int) (min * Math.pow(10, 3 - i));
        }
        return result;
    }
    int[] numToArray(int num) {
        String s = String.valueOf(num);
        int[] arr = new int[4];
        int j =0;
        for (int i = 0; i < 4; i++) {
            if (s.length() < 4 - i) {
                arr[i] = 0;
            } else {
                arr[i] = s.charAt(j++) - '0';
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateKey(987, 879, 798));

    }


}
