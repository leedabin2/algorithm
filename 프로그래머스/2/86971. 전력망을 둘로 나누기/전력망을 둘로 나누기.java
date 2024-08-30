import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE; 

        
        for (int i = 0 ; i < wires.length; i++) {
            int[][] temp = new int[wires.length-1][2]; 
            
            if(i>0) System.arraycopy(wires, 0, temp, 0, i);
            
            if(i<wires.length-1) System.arraycopy(wires, i+1, temp, i, wires.length - i - 1);
            
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 1; j < n+2; j++) {
                graph.add(new ArrayList<>());
            }
            
            for (int[] wire : temp) {
                graph.get(wire[0]).add(wire[1]);
                graph.get(wire[1]).add(wire[0]);
            }
            
            int res = bfs(1,graph,n);
            int diff = Math.abs(res - (n - res));
            answer = Math.min(answer, diff);
            
          
        }
        return answer;
    }
    
    private int bfs(int start,List<List<Integer>> graph,int n) {
        
        List<Integer> visited = new ArrayList<>();
        for (int i = 0; i < n+1 ; i++) {
            visited.add(0);
        }
        
        visited.set(start, 1);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        int cnt = 1;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int nextNode : graph.get(node)) {
                if (visited.get(nextNode) == 0) {
                    visited.set(nextNode,1);
                    queue.offer(nextNode);
                    cnt ++;
                }
            }
        }
        
        return cnt;
        
    }
    
    
}