import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, Comparator.comparingInt(a->a[1]));
        int cameraPosition = -9999999;
        
        for (int[] r : routes) {
            if (cameraPosition < r[0]) {
                cameraPosition = r[1];
                answer++;
            }
        }
        
        return answer;
    }
}