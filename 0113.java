public class 0113 {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int t = bandage[0]; // 붕대 시전 시간
        int x = bandage[1]; // 초당 회복량
        int y = bandage[2]; // 추가 회복량

        int time = 0; // 현재 시간
        int successTime = 0; // 연속 성공 시간
        int attackIndex = 0; // 공격 배열의 인덱스

        while (attackIndex < attacks.length || time <= attacks[attacks.length - 1][0]) {
            // 공격 처리
            if (attackIndex < attacks.length && attacks[attackIndex][0] == time) {
                health -= attacks[attackIndex][1]; // 공격 데미지
                if (health <= 0) {
                    return -1; // 캐릭터 사망
                }
                successTime = 0; // 연속 성공 초기화
                attackIndex++;
            } else {
                // 붕대 기술 사용
                if (successTime < t) {
                    health += x; // 초당 회복
                    health = Math.min(health, maxHealth); // 최대 체력 초과 방지
                    successTime++;
                }

                // t초 연속 성공 시 추가 회복 적용
                if (successTime == t) {
                    health += y;
                    health = Math.min(health, maxHealth); // 최대 체력 초과 방지
                    successTime = 0; // 성공 초기화
                }
            }
            time++; // 시간 증가
        }

        return health; // 최종 체력 반환
    }

    public static void main(String[] args) {
        // 테스트 케이스 1
        int[] bandage1 = {5, 1, 5};
        int health1 = 30;
        int[][] attacks1 = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution(bandage1, health1, attacks1)); // 5

        // 테스트 케이스 2
        int[] bandage2 = {3, 2, 7};
        int health2 = 20;
        int[][] attacks2 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println(solution(bandage2, health2, attacks2)); // -1

        // 테스트 케이스 3
        int[] bandage3 = {4, 2, 7};
        int health3 = 20;
        int[][] attacks3 = {{1, 15}, {5, 16}, {8, 6}};
        System.out.println(solution(bandage3, health3, attacks3)); // -1

        // 테스트 케이스 4
        int[] bandage4 = {1, 1, 1};
        int health4 = 5;
        int[][] attacks4 = {{1, 2}, {3, 2}};
        System.out.println(solution(bandage4, health4, attacks4)); // 3
    }
}