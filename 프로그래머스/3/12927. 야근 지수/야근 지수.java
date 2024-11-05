import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int work : works) {
            q.offer(work);
        }
        
        for (int i =0 ; i < n; i++) {
            if (q.isEmpty()) {
                break;
            } else {
                int work = q.poll();
                if (work > 0) {
                    q.offer(work - 1);
                }
            }
        }
        
        while (!q.isEmpty()) {
            int curr = q.poll();
            answer += Math.pow(curr,2);
        }
        
        
        return answer;
    }
}