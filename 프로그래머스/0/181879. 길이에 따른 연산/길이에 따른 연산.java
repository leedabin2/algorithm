import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        if (num_list.length >= 11 ) {
            answer = Arrays.stream(num_list).sum();
            return answer;
        }
        
        return Arrays.stream(num_list).reduce(1,(a,b) -> a * b);
    }
}