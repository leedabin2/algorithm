import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
      
        int interval = n;
        List<Integer> res = new ArrayList<>();
        
        for (int i = 0 ; i < num_list.length; i += interval) {
            res.add(num_list[i]);
        }
        
        int[] answer = res.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}