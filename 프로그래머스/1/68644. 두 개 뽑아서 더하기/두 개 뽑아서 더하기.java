import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {

        Set<Integer> result = new HashSet<>();  
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                result.add(numbers[i] + numbers[j]);  // 두 수의 합을 Set에 추가
            }
        }
        int[] answer = new int[result.size()];
        int idx = 0;
        for (int sum : result) {
            answer[idx++] = sum;
        }
        
        Arrays.sort(answer);

        return answer;
    }
}