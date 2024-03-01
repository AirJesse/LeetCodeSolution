package leetCode_75.q605_种花问题;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int right = -1;
        int left = 1;
        if(n==0) return true;
        for (int mid = 0; mid < flowerbed.length; mid++,right++,left++) {
            if (flowerbed[mid] == 1) {
                continue;
            }
            if (right >= 0 && flowerbed[right] == 1) {
                continue;
            }
            if (left < flowerbed.length && flowerbed[left] == 1) {
                continue;
            }
            flowerbed[mid] = 1;
            if(--n==0){
                break;
            }
        }

        return n == 0;
    }
}
