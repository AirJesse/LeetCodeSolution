package leetCode_75.q933_最近的请求次数;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RecentCounter {
    List<Integer> list;
    public RecentCounter() {
        list = new ArrayList<>();
    }

    public int ping(int t) {
        list.add(t);
        int left = t-3000;
        if(left<=0){
            return list.size();
        }
        int result = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if(list.get(i)>= left){
                result++;
            }else{
                break;
            }
        }
        return result;
    }
}
