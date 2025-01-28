class Solution {
    public int[] solution(String[] cpr) {
        int[] answer = {0, 0, 0, 0, 0};
        String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

        for(int i = 0; i < cpr.length; i++) {  // cpr 배열의 길이만큼 반복
            for(int j = 0; j < basic_order.length; j++) {  // 기본 순서 배열 탐색
                if(cpr[i].equals(basic_order[j])) {  // cpr의 요소와 basic_order 비교
                    answer[j]++;  // 해당 순서의 카운트 증가
                    break;  // 중복 카운트를 방지하기 위해 중단
                }
            }
        }
        return answer;
    }
}