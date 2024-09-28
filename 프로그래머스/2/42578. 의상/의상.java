import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        ConcurrentHashMap<String,Set<String>> set = new ConcurrentHashMap<>();
        for (String[] c : clothes) {
            set.computeIfAbsent(c[1], k -> new HashSet<>()).add(c[0]);
        }
        
       
        for (Set<String> clothesSet : set.values()) {
            answer *= (clothesSet.size() + 1);
        }
    
        
        
        return answer -1;
    }
}