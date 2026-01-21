import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        int[] n = new int[10];
        Arrays.fill(n, -1);
        
        for (int i = 0; i < numbers.length; i++) {
            n[numbers[i]] = 0;
        }
        
        for (int i = 0; i <= 9; i++) {
            if (n[i] == -1) {
                answer += i;
            }
        }
        
        return answer;
    }
}