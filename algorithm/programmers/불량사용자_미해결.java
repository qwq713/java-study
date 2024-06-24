package algorithm.programmers;

import java.util.*;

public class 불량사용자_미해결 {
    private boolean isMatch(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len != s2Len) {
            return false;
        }
        for (int i = 0; i < s1Len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if ('*' != s2.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int solution(String[] user_id, String[] banned_id) {
        Map<String, List<String>> map = new HashMap<>();
        for (String banId : banned_id) {
            map.put(banId, new ArrayList<>());
            for (String userId : user_id) {
                if (isMatch(userId, banId)) {
                    map.get(banId).add(userId);
                }
            }
        }
        List<Set<String>> setList = new ArrayList<>();
        for(String banId : map.keySet()){
            List<String> userIdList = map.get(banId);

        }


        int answer = 0;
        return answer;
    }
}
