package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfaPhoneNumber {
    public static void main(String[] args) {
        List<String> result = new Solution02().letterCombinations("23");
        System.out.println(result.size());
        System.out.println(result);

        result = new Solution02().letterCombinations("");
        System.out.println(result.size());
        System.out.println(result);

        result = new Solution02().letterCombinations("2");
        System.out.println(result.size());
        System.out.println(result);

        result = new Solution02().letterCombinations("2345");
        System.out.println(result.size());
        System.out.println(result);

        result = new Solution02().letterCombinations("79");
        System.out.println(result.size());
        System.out.println(result);
    }
}

class Solution02 {
    static Map<Integer, List<Character>> map;

    private Map<Integer, List<Character>> buildMap() {
        Map<Integer, List<Character>> map = new HashMap<>();
        map.put(2, List.of('a', 'b', 'c'));
        map.put(3, List.of('d', 'e', 'f'));
        map.put(4, List.of('g', 'h', 'i'));
        map.put(5, List.of('j', 'k', 'l'));
        map.put(6, List.of('m', 'n', 'o'));
        map.put(7, List.of('p', 'q', 'r', 's'));
        map.put(8, List.of('t', 'u', 'v'));
        map.put(9, List.of('w', 'x', 'y', 'z'));
        return map;
    }

    public void dfs(int nowIdx, String prevString, String digits, List<String> result) {
        // todo : return 조건을 다음과 같이 바꿔보자
        //  dfs 종료 조건을 맨 위에 정의하는걸로..
        //  생성 문자 == digits.length -> result.add & return
        if (nowIdx == digits.length()) {
            return;
        }

        int numericValue = Character.getNumericValue(digits.charAt(nowIdx));
        List<Character> charList = map.get(numericValue);

        for (char c : charList) {
            String nowString = prevString + c;
            if (nowString.length() == digits.length()) {
                result.add(nowString);
            } else {
                // next -> nowIdx + 1 && digits 이용
                int nextIdx = nowIdx + 1;
                dfs(nextIdx, nowString, digits, result);
            }
        }
    }


    public List<String> letterCombinations(String digits) {
        map = buildMap();
        List<String> result = new ArrayList<>();
        Map<Integer, List<Character>> map = buildMap();
        String initString = "";
        dfs(0, initString, digits, result);
        return result;

    }
}
