import java.util.*;
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        // fr*d* : {frodo, fradi}, abc1** : {abc123}
        // *rodo : {frodo, crodo}, *rodo : {frodo, crodo}, ***** : {abc123, frodoc}
        // fr*d* : {frodo, fradi}, *rodo : {frodo, crodo}, ***** : {abc123, frodoc},  ***** : {abc123, frodoc}
        
        Map<String,Set<String>> map = new HashMap<>();
        
  
        for (String banId : banned_id) {
            Set<String> matchingUsers = new HashSet<>();
            for (String userId : user_id) {
                if (isMatch(banId, userId)) {
                    matchingUsers.add(userId);
                }
            }
            map.put(banId, matchingUsers);
        }
        
        // 중복 제거된 유효한 사용자 ID 조합을 찾음
        List<Set<String>> candidates = new ArrayList<>();
        for (String banId : banned_id) {
            candidates.add(map.get(banId));  
        }

        Set<Set<String>> uniqueCombinations = new HashSet<>();
        findCombinations(candidates, 0, new HashSet<>(), uniqueCombinations);
        
        answer = uniqueCombinations.size(); // 가능한 경우의 수
        
        
        return answer;
    }
    private boolean isMatch(String banId, String userId) {
        if (banId.length() != userId.length()) return false;
        
        for (int i =0; i < banId.length(); i++) {
            if (banId.charAt(i) != '*' && banId.charAt(i) != userId.charAt(i)) return false;
        }
        return true;
    }
     // 모든 가능한 조합을 찾는 재귀 함수
    private void findCombinations(List<Set<String>> candidates, int idx, Set<String> currentSet, Set<Set<String>> uniqueCombinations) {
        if (idx == candidates.size()) {
            uniqueCombinations.add(new HashSet<>(currentSet));
            return;
        }
        
        for (String userId : candidates.get(idx)) {
            if (!currentSet.contains(userId)) {
                currentSet.add(userId);
                findCombinations(candidates, idx + 1, currentSet, uniqueCombinations);
                currentSet.remove(userId);
            }
        }
    }
 

}