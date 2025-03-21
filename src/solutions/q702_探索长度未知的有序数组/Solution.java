package solutions.q702_探索长度未知的有序数组;

public class Solution {
    public int search(ArrayReader reader, int target) {
        int left = 0, right = 10000;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (reader.get(mid) == target) {
                return mid;
            }
            if (reader.get(mid) > target) {
                right = mid - 1;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            }


        }
        return -1;

    }

}

class ArrayReader {
    public int get(int index) {
        return 0;
    }
}
