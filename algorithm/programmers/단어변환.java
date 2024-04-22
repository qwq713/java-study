package algorithm.programmers;

import java.util.*;

public class 단어변환 {
    /**
     * visit 체크 중요.
     * bfs 경우 push 하기 전에 visit 수행하기.
     * */
    static class Pair {
        public int now;
        public int distance;

        Pair(int now, int distance) {
            this.now = now;
            this.distance = distance;
        }
    }

    private boolean beChange(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount += 1;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        List<String> newWords = new ArrayList<>(Arrays.asList(words));
        newWords.add(0, begin);
        boolean[] visit = new boolean[words.length + 1];

        // target 이 words 안에 없는 경우
        Optional<String> findFirst = Arrays.stream(words).filter(word -> word.equals(target)).findFirst();
        if (findFirst.isEmpty()) {
            return 0;
        }

        Deque<Pair> deque = new ArrayDeque<>();
        deque.push(new Pair(0, 0));
        while (!deque.isEmpty()) {
            Pair pair = deque.poll();
            int now = pair.now;
            int nowDistance = pair.distance;
            String nowString = newWords.get(now);

            if (newWords.get(now).equals(target)) {
                answer = nowDistance;
                break;
            }
            for (int next = 0; next < newWords.size(); next++) {
                String nextString = newWords.get(next);
                int nextDistance = nowDistance + 1;
                if (now != next && !visit[next] && beChange(nowString, nextString)) {
                    visit[now] = true;
                    deque.push(new Pair(next, nextDistance));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int result = new 단어변환().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        System.out.println(result);

        int result2 = new 단어변환().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});
        System.out.println(result2);
    }
}
