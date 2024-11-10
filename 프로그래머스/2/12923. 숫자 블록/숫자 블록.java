class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];
        
        int index = 0;
      
        for (long i = begin; i <= end ; i++) {
            if (i == 1) {
                answer[index++] = 0;
                continue;
            }
            
            int max = 1;
            for (long j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    max = (int) j;
                    
                    if (i / j <= 10000000) {
                        max = (int)(i / j);
                        break;  
                    }
                }
            }
            answer[index++] = max;
        }
        
        return answer;
    }
}