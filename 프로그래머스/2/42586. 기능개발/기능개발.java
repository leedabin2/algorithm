import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        Deque<Integer> q = new ArrayDeque<>();
        double n = 1.0;
       
        for (int i = 0; i < speeds.length ; i++) {
            n = (100.0 - progresses[i]) /speeds[i];
            int roundedValue = (int) Math.ceil(n);
            q.offer(roundedValue);
           
        }
    
        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()) {
            int depoly = q.poll();
            int count = 1;
            while(!q.isEmpty() && depoly >= q.peek()){
                q.poll();
                count++;
            }
            result.add(count);
        }
        
    
        return result.stream().mapToInt(i->i).toArray();
    }
}