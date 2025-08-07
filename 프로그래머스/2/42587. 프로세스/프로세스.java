import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int n = priorities.length;
        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int i =0; i < n; i++ ) {
            queue.add(new int[]{i,priorities[i]}); // idx, 중요도
        }
        
        int order = 0;
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            boolean isHigher = false;
            
            for (int[] q : queue) {
                if (q[1] > curr[1]) {
                    isHigher = true;
                    break;
                }
            }
            
            if (isHigher) {
                queue.addLast(curr);
            } else {
                order++;
                if (curr[0] == location) {
                    return order;
                }
            }
        }
            
        return answer;
    }
}