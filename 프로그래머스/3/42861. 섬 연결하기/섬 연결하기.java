import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
    
        Map<Integer,Map<Integer,Integer>> ans = new HashMap<>();
        
        for (int[] cost : costs) {
            int k = cost[0];
            int node = cost[1];
            int weight = cost[2];
    
            ans.putIfAbsent(k, new HashMap<>());
            ans.putIfAbsent(node, new HashMap<>());
            
            ans.get(k).put(node,weight);
            ans.get(node).put(k,weight);
        }
        
    
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>(); 
        

        pq.add(new int[]{0, 0});
        

        while (visited.size() < n) {
            int[] curr = pq.poll();
            int currentNode = curr[0];
            int currentCost = curr[1];
            
      
            if (visited.contains(currentNode)) {
                continue;
            }
            
            
            visited.add(currentNode);
            answer += currentCost;
            
          
            for (int nextNode : ans.get(currentNode).keySet()) {
                if (!visited.contains(nextNode)) {
    
                    pq.add(new int[]{nextNode, ans.get(currentNode).get(nextNode)});
                }
            }
        }
        return answer;
    }
}