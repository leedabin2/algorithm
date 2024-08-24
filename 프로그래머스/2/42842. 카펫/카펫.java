class Solution {
    public int[] solution(int brown, int yellow) {

        int[] answer = {};        
        int total = brown + yellow;
        
        for (int i = 1; i < (total/2)+1; i++ ) {
                            
            if (total % i == 0) {
                int width = total / i;
                 if ((width - 2) *(i - 2) == yellow) {
                        return new int[]{width,i};
                 }
            }
              
            
        }
        return answer;
    }
}