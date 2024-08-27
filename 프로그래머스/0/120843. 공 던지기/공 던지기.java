class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int res = 0;
        
        for (int i = 1 ; i < k; i++) {
            res += 2;
            if( res >= numbers.length) {
                res -= numbers.length;
            }
        }
  
        return numbers[res];
    }
}