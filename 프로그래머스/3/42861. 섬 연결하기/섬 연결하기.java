import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<List<int[]>> graph = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
             graph.add(new ArrayList<>());
        }
        
        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int pay = cost[2];
            
            graph.get(a).add(new int[]{b, pay});
            graph.get(b).add(new int[]{a, pay});
        }
        
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        visited[0] = true;
        for (int[] edge : graph.get(0)) {
            pq.add(new int[]{edge[0], edge[1]});
        }
        
        int totalCost = 0;
        
        while(!pq.isEmpty()) {
            int[] curr =pq.poll();
            
            int node = curr[0], currCost = curr[1];
            
            if (visited[node]) continue;
            visited[node] = true;
            totalCost += currCost;
            
            for (int[] next : graph.get(node)) {
                int nextNode = next[0], cost = next[1];
                if (!visited[nextNode]) {
                    pq.add(new int[]{nextNode, cost});
                }
            }
        }
        
        
        return totalCost;
    }
}