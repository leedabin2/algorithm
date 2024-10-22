import java.util.*;

class Solution {
    public String solution(String number, int k) {

        StringBuilder result = new StringBuilder();
        Integer len = number.length() - k;
        Integer idx = 0;
        for (int i=0; i < len; i++) {
            char max = '0';
            for (int j = idx; j <= k + i; j++) {
                if (number.charAt(j) > max) {
                    max = number.charAt(j);
                    idx = j + 1;
                }
            }
            result.append(max);
        }
   
        
        return result.toString();
    }
}