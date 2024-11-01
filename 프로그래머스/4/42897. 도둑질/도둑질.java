import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int n = money.length;

        int[] firstDp = new int[n];
        
        firstDp[0] = money[0];
        firstDp[1] = Math.max(money[0],money[1]);
        for (int i = 2; i < n-1; i++) {
            firstDp[i] = Math.max(firstDp[i-1],firstDp[i-2] + money[i]);
        }
        
    
        int[] lastDp = new int[n];
        lastDp[0] = 0;
        lastDp[1] = money[1];
        
        for (int i = 2; i < n; i++) {
            lastDp[i] = Math.max(lastDp[i-1],lastDp[i-2] + money[i]);
        }
       
        int firstMaxvalue = Arrays.stream(firstDp).max().getAsInt();
        int lastMaxvalue = Arrays.stream(lastDp).max().getAsInt();
 
        return Math.max(firstMaxvalue,lastMaxvalue);
    }
}