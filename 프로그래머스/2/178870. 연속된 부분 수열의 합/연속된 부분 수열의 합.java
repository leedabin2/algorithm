class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int start = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int endIdx = 0;
        int minStart = Integer.MAX_VALUE;
        
        
        for (int end = 0; end < sequence.length; end++) {
            sum += sequence[end];
            
            while (sum >= k) {
                if (sum == k) { 
                  int currLen = end - start + 1;
                  if (currLen < minLen) {
                    minLen = currLen;
                    answer[0] = start;
                    answer[1] = end;
                    }
                }
                sum -= sequence[start];
                start++;
            }
        }
        

        return answer;
    }
}