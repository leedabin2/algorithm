import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        Map<String,Map<String,Integer>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            String a = ticket[0];
            String b = ticket[1];
            map.computeIfAbsent(a, k -> new TreeMap<>())
                .put(b, map.get(a).getOrDefault(b,0) + 1);
        }

        List<String> result = new ArrayList<>();
        dfs("ICN",result,map,tickets.length+1);
        return result.toArray(new String[0]);
    }
    private boolean dfs(String start, List<String> result, Map<String,Map<String,Integer>> map, int total) {
        result.add(start);
        if (result.size() == total) {
            return true;
        }
        
         if (!map.containsKey(start)) {
            result.remove(result.size() - 1);
            return false;
        }
        for (Map.Entry<String,Integer> entry : map.get(start).entrySet()) {
     
            String next = entry.getKey();
            Integer count = entry.getValue();
            
            
            if (count > 0) {
                map.get(start).put(next,count-1);
                if (dfs(next,result,map,total)) {
                    return true;
                } else {
                    map.get(start).put(next,count);
                }
                     
            }
        }
        
         result.remove(result.size() - 1); 
   
        return false;
        
    }
}