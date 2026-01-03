import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0; // 실행 순서
        int n = priorities.length;
        
        // {idx, pri}
        Deque<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            queue.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            
            int idx = curr[0];
            int pri = curr[1];
            
            if (pq.peek() > pri) {
                queue.addLast(curr);
            } else {
                answer++;
                pq.poll();
                if (idx == location) {
                    break;
                } 
            }
                
        }
        

        
        
        
        
        
        
        return answer;
    }
}