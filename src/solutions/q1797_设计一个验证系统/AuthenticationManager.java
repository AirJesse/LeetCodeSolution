package solutions.q1797_设计一个验证系统;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationManager {
    private int timeToLive;
    private HashMap<String, Integer> authMap = new HashMap<>();

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        authMap.put(tokenId,currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        Integer time = authMap.get(tokenId);
        if(time != null && time+timeToLive > currentTime){
            authMap.put(tokenId,currentTime);
        }

//        if(time == null || currentTime >= (time+ timeToLive)){
//            return;
//        }

    }

    public int countUnexpiredTokens(int currentTime) {
        int count =0;
        for (Map.Entry<String, Integer> keyTimeEntry : authMap.entrySet()) {
            if(keyTimeEntry.getValue() + timeToLive > currentTime) {
                count++;
            }
        }
        return count;
    }
}
