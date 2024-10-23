import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        // [2,11,14,17,21,25]
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        
        while (left <= right) {
            int mid = (left + right) / 2;
         
            int remove = 0;
            int prev = 0;
            
            for (int rock : rocks) {
                if (rock - prev < mid ) {
                    remove++;
                } else {
                    prev = rock;
                }
            }
            
            if (distance - prev < mid) {
                remove++;
            }
            if (remove > n) {
                right = mid -1;
            } else {
                answer = mid;
                left = mid + 1;
            }
        }
  
        return answer;
    }
}