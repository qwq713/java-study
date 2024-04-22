package algorithm.programmers;

import java.util.PriorityQueue;

public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHq = new PriorityQueue<>();
        PriorityQueue<Integer> maxHq = new PriorityQueue<>((n1, n2) -> n2 - n1);

        for (String operation : operations) {
            String[] commands = operation.split(" ");
            String action = commands[0];
            String number = commands[1];
            if (action.equals("I")) {
                // insert
                minHq.add(Integer.parseInt(number));
                maxHq.add(Integer.parseInt(number));

            }
            if (action.equals("D")) {
                // delete
                if (number.equals("1")) {
                    // max remove
                    minHq.remove(maxHq.poll());
                }

                if (number.equals("-1")) {
                    // min remove
                    maxHq.remove(minHq.poll());
                }
            }
        }
        if (minHq.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{maxHq.peek(), minHq.peek()};
    }

    public static void main(String[] args) {
        String[] input01 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] input02 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] result01 = new 이중우선순위큐().solution(input01);
        int[] result02 = new 이중우선순위큐().solution(input02);
        System.out.println(result01[0] + " , " +result01[1]);
        System.out.println(result02[0] + " , " +result02[1]);
    }
}
