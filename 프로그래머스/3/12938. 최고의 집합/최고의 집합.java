import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
     
        int[] answer = new int[n];
    
        if (n > s) {
            return new int[]{-1};
        }
        

        int base = s / n; 
        int remain = s % n;  
        
        if (base == 0) {
            return new int[]{-1};
        }
 
        Arrays.fill(answer, base);
        // System.out.println(Arrays.toString(answer));

        for (int i = 0; i < remain; i++) {
            answer[i]++; 
        }
        

        Arrays.sort(answer);
      
        return answer; 
    }
}