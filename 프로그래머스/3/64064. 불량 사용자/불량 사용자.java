import java.util.*;

class Solution {
    Set<Set<String>> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        Set<String> res = new HashSet<>();
        List<List<String>> matching = new ArrayList<>();
        
        for (String banned : banned_id) {
            List<String> matched = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(user,banned)){
                    matched.add(user);
                }
            }
            matching.add(matched);
        }
 
        findCombination(new HashSet<>(),matching,0 );
     
        return result.size();
    }
    private boolean isMatch(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }
        for (int i = 0; i < banned.length(); i++) {
            if (banned.charAt(i) != '*' && banned.charAt(i) != user.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    private void findCombination(Set<String> curr , List<List<String>> matching, int index) {
     
        if (index == matching.size()) {
            result.add(new HashSet<>(curr));
            return;
        }
        for (String user :matching.get(index) ) {
            if (!curr.contains(user)) {
                curr.add(user);
                findCombination(curr, matching, index+1);
                curr.remove(user);
            }
        }
    }
}