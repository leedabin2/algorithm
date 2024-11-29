import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
  
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        for (String num : arr) {
            int numToInt = Integer.valueOf(num);
            maxNum = Math.max(numToInt,maxNum);
            minNum = Math.min(numToInt,minNum);
        }
        answer = minNum + " " + maxNum;
        return answer;
    }
}