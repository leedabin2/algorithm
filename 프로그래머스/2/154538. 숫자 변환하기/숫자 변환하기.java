import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y) {
            return 0;
        }
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,0});
        boolean[] visited = new boolean[y+1];
        visited[x] = true;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            
            int currNumber = curr[0];
            int step = curr[1];
       
            int[] calculator = {currNumber + n, currNumber * 2 , currNumber * 3};
            for (int c : calculator) {
                if (c > y || c < 0) continue; 
                if (c == y) return step + 1;
                if (!visited[c]) {
                    visited[c] = true;
                    q.offer(new int[] {c, step+1});
                }
            }
        }
        return -1;
    }
}