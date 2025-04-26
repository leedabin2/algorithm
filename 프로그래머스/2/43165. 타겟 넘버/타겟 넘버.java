class Solution {
    public int solution(int[] numbers, int target) {  
        return dfs(0,numbers,target,0);
    }
    private int dfs(int idx, int[] numbers, int target, int value) {
        
        if (idx == numbers.length) {
            if (value == target) {
                return 1;
            }
            return 0;
        }
        
        int add = dfs(idx+1,numbers,target,value + numbers[idx]);
        int minus = dfs(idx+1,numbers,target,value - numbers[idx]);
        
        return add + minus;
          
    }
}