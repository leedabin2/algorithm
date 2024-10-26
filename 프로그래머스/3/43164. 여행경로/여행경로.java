import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        List<String> result = new ArrayList<>();
     
     
        HashMap<String, Map<String, Integer>> ticket = new HashMap<>();
        for (String[] t : tickets) {
            String a = t[0];
            String b = t[1];
            ticket.computeIfAbsent(a, k -> new TreeMap<>()).put(b, ticket.getOrDefault(a, new HashMap<>()).getOrDefault(b, 0) + 1);
        }

        
        dfs("ICN", ticket, result, tickets.length + 1);
        
      
        return result.toArray(new String[0]);
    }
    
    public boolean dfs(String current, HashMap<String, Map<String, Integer>> ticket, List<String> result, int totalTickets) {
        result.add(current);
        
        if (result.size() == totalTickets) {
            return true; 
        }

     
        if (ticket.containsKey(current)) {
            for (Map.Entry<String, Integer> entry : ticket.get(current).entrySet()) {
                String next = entry.getKey();
                int count = entry.getValue();

                if (count > 0) { 
                    ticket.get(current).put(next, count - 1); 
                    if (dfs(next, ticket, result, totalTickets)) {
                        return true; 
                    } else {
                    ticket.get(current).put(next, count);
                    }
                }
            }
        }

    
        result.remove(result.size() - 1);
        return false;
    }
}
