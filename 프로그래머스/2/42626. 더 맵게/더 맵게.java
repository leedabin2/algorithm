import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int cnt = 0;
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for (int s : scoville) {
            min.offer(s);
        }
        
        int sc = 0;
        
    
        while (min.size() > 1) {
             if (min.peek() >= K) {
                return cnt;
            } 
            int minFirstSc = min.poll();
            int minSecondSc = min.poll();
            sc = minFirstSc + (minSecondSc * 2);  
            min.offer(sc); 
            cnt++;
            
        }
        
        if (min.peek() >= K) {
            return cnt;
        }
       
        return -1;
    }
}