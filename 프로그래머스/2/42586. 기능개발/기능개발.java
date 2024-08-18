import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    
        // 작업 일수
        Deque<Integer> workDays = new ArrayDeque<>();

        for (int i = 0 ; i < progresses.length; i++) {
            int work = 1;
            while ((speeds[i] * work) + progresses[i] < 100) {
                work += 1;
            }
            workDays.add(work);
        }

        List<Integer> result = new ArrayList<>();
        int deploy = 1;
        int current = workDays.poll(); 

        while (!workDays.isEmpty()) {
            int next = workDays.poll();

            if (next <= current) {
           
                deploy++;
            } else {
            
                result.add(deploy);
                deploy = 1;
                current = next;
            }
        }
        
      
        result.add(deploy);
        
        return result.stream().mapToInt(i->i).toArray();
    }
}