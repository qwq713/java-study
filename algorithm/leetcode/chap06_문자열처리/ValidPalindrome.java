package algorithm.leetcode.chap06_문자열처리;

public class ValidPalindrome {
    class Solution {
        public static boolean isPalindrome(String s) {
            String lowerCase = s.toLowerCase();
            String target = "";
            for (int i = 0; i < lowerCase.length(); i++) {
                char c = lowerCase.charAt(i);
                if (('a' <= c && c <= 'z') || ('0' <= c && c <= '9')) {
                    target += Character.toString(c);
                }
            }
            for (int i = 0; i < target.length() / 2; i++) {
                if (target.charAt(i) != target.charAt(target.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }

        // Chracter.toLowerCase
        // Chracter.isLetterOrDigit

        public static boolean isPalindromeSolution(String s) {
            int start = 0;
            int end = s.length() - 1;
            while (start < end) {
                if (!Character.isLetterOrDigit(s.charAt(start))) {
                    start++;
                } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                    end--;
                } else {
                    if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                        return false;
                    }
                    start++;
                    end--;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(Solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(Solution.isPalindromeSolution("A man, a plan, a canal: Panama"));
    }
}
