import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int compWeight = 0;
        int truckIndex = 0;
        
        Deque<Integer> work = new ArrayDeque<>();
        for (int i =0 ; i < bridge_length; i++) {
            work.add(0);
        }
        
        while (truckIndex < truck_weights.length) {
            time += 1;
            compWeight -= work.pollLast();
            if (compWeight + truck_weights[truckIndex] <= weight) {
                work.addFirst(truck_weights[truckIndex]);
                compWeight += truck_weights[truckIndex];
                truckIndex+=1;
                
            } else {
                work.addFirst(0);
            }
        }
        
        time += bridge_length;
        
        return time; 
        
        
    }
}