import java.util.Stack;

public class Solution {
    public static int solution(String s) {
        // Stack을 사용하여 숫자와 'Z' 처리
        Stack<Integer> stack = new Stack<>();
        String[] tokens = s.split(" ");

        for (String token : tokens) {
            if (token.equals("Z")) {
                if (!stack.isEmpty()) {
                    stack.pop(); // 이전 숫자 제거
                }
            } else {
                // 숫자인 경우 Stack에 추가
                stack.push(Integer.parseInt(token));
            }
        }

        // Stack에 남아 있는 숫자를 모두 더하기
        int answer = 0;
        for (int num : stack) {
            answer += num;
        }

        return answer;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution("10 20 30 Z 40")); // 70
        System.out.println(solution("10 + 20 + 30 + 40")); // 100
        System.out.println(solution("10 Z 20 Z 1")); // 1
        System.out.println(solution("10 Z Z Z Z")); // 0
        System.out.println(solution("10 20 30 Z Z Z")); // 0
    }
}