import java.util.*;

class Solution {
    public int solution(int[] cookie) {
        int answer = 0;
     
       
        for (int i = 0; i < cookie.length-1; i++) {
            int firstSum = cookie[i];
            int firstIndex = i;
            
            int secondSum = cookie[i+1];
            int secondIndex = i+1;
            
            while (true) {
                if (firstSum == secondSum) {
                    answer = Math.max(answer,firstSum);
                    if (firstIndex > 0) {
                        firstIndex--;
                        firstSum += cookie[firstIndex];
                    } else if (secondIndex < cookie.length - 1) {
                        secondIndex++;
                        secondSum += cookie[secondIndex];
                    }
                    else {
                        break;
                    }
                }
                else if (firstSum < secondSum) {
                    if (firstIndex > 0) {
                        firstIndex--;
                        firstSum += cookie[firstIndex];
                    }
                    else {
                        break;
                    }
                }
                else {
                    if (secondIndex < cookie.length - 1) {
                        secondIndex++;
                        secondSum += cookie[secondIndex];
                    } else {
                        break;
                    }
                }
            }
        }
     
        return answer;
    }
}