package solutions.q5981_分组得分最高的所有下标;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int leftScore = 0, rightScore = 0;
        for (int num : nums) {
            if (num == 1) {
                rightScore++;
            }
        }
        int maxScore = rightScore;
        result.add(0);
        for (int n = 0; n < nums.length; n++) {
            if (nums[n] == 1) {
                rightScore--;
            } else {
                leftScore++;
            }
            if (leftScore + rightScore > maxScore) {
                maxScore = leftScore + rightScore;
                result.clear();
                result.add(n + 1);
            } else if (leftScore + rightScore == maxScore) {
                result.add(n + 1);
            }
        }
        return result;
    }
}
