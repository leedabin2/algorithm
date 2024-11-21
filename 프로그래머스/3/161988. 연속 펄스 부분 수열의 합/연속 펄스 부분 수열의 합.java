import java.util.*;
class Solution {
    public long solution(int[] sequence) {
    
        long maxSum = 0;
        int n = sequence.length;
        if (n == 1) {
            if (sequence[0] < 0) return sequence[0] * -1;
            else return sequence[0];
        }
        
  
        long maxSum1 = 0; 
        long maxSum2 = 0; 
        long currSum1 = 0;
        long currSum2 = 0;

        for (int i = 0; i < n; i++) {
            long value1 = (i % 2 == 0) ? sequence[i] : -sequence[i];
            long value2 = (i % 2 == 0) ? -sequence[i] : sequence[i];
            
            currSum1 = Math.max(value1, currSum1 + value1 );
            currSum2 = Math.max(value2, currSum2 + value2);
            
            maxSum1 = Math.max(currSum1, maxSum1);
            maxSum2 = Math.max(currSum2, maxSum2);    
        }

        return Math.max(maxSum1, maxSum2);
     
    }
}