import java.util.*;

class Solution {
    public int solution(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
    
        
        int size = nums.length/2;
    
        return Math.min(size,set.size());
    }
}