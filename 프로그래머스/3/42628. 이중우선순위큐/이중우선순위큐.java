import java.util.PriorityQueue;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minq = new PriorityQueue();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] part = operation.split(" ");
            String command = part[0];
            int number = Integer.parseInt(part[1]);
            
            if (command.equals("I")) {
                minq.offer(number);
                maxq.offer(number);
            } else if (command.equals("D")){
                if (number == 1) {
                if (!maxq.isEmpty()) {
                    int max = maxq.poll();
                    minq.remove(max);
                } 
                } else if (number == -1 ) {
                    if (!minq.isEmpty()){
                        int min = minq.poll();
                        maxq.remove(min);
                    }
                }
            }
        }
                
        if (!maxq.isEmpty() && !minq.isEmpty()) {
            return new int[]{maxq.poll(),minq.poll()};
        }
        
        return new int[]{0,0};
    }
}