class Solution {
    public int solution(int[] numbers, int target) {
        return recur(0,numbers,target,0);
    }
    
    public int recur(int index, int[] number, int target, int curr) {
        int res = 0;
        if (index == number.length) {
            if (target == curr){
                return 1;
            }else {
                return 0;
            }
               
        }
        
         int add = recur(index+1,number,target,curr + number[index]);
         int minus = recur(index+1,number,target,curr - number[index]);
        
        return add + minus;
        
    }
}