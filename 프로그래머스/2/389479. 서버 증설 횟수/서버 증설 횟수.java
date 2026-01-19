import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int curServers = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int time = 0; time < 24; time++) {
            
            while(!pq.isEmpty() && pq.peek() <= time ) {
                pq.poll();
                curServers--;
            }
            // 필요한 서버
            int needed = players[time] / m;
            
            if (needed > curServers) {
                int toAdd = needed - curServers;
                curServers += toAdd;
                answer += toAdd;
                
                for (int i =0; i < toAdd; i++) {
                    pq.add(time + k);
                }
            }
        }
        return answer;
    }
}