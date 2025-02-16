import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        // spell 배열을 Set으로 변환 (중복 제거 및 빠른 비교)
        Set<String> spellSet = new HashSet<>(Arrays.asList(spell));

        // dic 배열을 순회하며 spell과 일치하는 단어가 있는지 확인
        for (String word : dic) {
            // dic의 단어를 Set으로 변환
            Set<String> wordSet = new HashSet<>(Arrays.asList(word.split("")));
            
            // spellSet과 wordSet이 동일하면 1 반환
            if (spellSet.equals(wordSet)) {
                return 1;
            }
        }
        
        // 일치하는 단어가 없다면 2 반환
        return 2;
    }
}