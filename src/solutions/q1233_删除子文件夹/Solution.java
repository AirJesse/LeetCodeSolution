package solutions.q1233_删除子文件夹;

import java.util.*;


public class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String > result = new ArrayList<>();
        Set<String> set = new HashSet<>(Arrays.asList(folder));
        for (String s : folder) {
            String[] split = s.split("/");
            StringBuilder sb = new StringBuilder();
            boolean isSub = false;
            for (int i = 1; i < split.length - 1; i++) {
                sb.append("/").append(split[i]);
                if (set.contains(sb.toString())) {
                    isSub=true;
                    break;
                }
            }
            if(!isSub){
                result.add(s);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new Solution().removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"});
    }
}
