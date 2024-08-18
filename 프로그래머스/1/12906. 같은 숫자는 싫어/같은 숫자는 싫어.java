import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        List<Integer> arr1 = new ArrayList<>();
        for (int i : arr) {
            arr1.add(i);
        }
        Deque<Integer> answer = new ArrayDeque<>();
        answer.push(arr1.remove(0));
        
        for (int i : arr1) {
            if (i != answer.peekLast()) {
                answer.add(i);
            }
        }

        
        return answer.stream().mapToInt(i->i).toArray();
    }
}