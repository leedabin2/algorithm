import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        List<int[]> tuple = new ArrayList<>();
        for (int num : numbers) {
            tuple.add(new int[]{-num,num});
        }
     
        List<Integer> sum = new ArrayList<>();
        product(tuple,0,0,sum);
        
        int cnt = 0;
        for (int s : sum) {
            if (s == target) {
                cnt++;
            }
        }
            
        return cnt;
    }
    
    public void product(List<int[]> tuple, int index, int curr, List<Integer> sum) {
        if (index == tuple.size()) {
            sum.add(curr);
            return;
        }
        
        for (int v : tuple.get(index)) {
        
             product(tuple,index+1,curr+v,sum);
        }
        
         
    }
}