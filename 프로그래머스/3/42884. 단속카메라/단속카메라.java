import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 진출이 작은 것부터 
        Arrays.sort(routes, (a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            return a[0] - b[0];
        });
         
        int camera = routes[0][1];
        int cnt = 1;

        for (int i = 1; i < routes.length; i++) {
            if (camera < routes[i][0]) {
                // 새 카메라 필요
                camera = routes[i][1];
                cnt++;
            }
            
        }
            
        return cnt;
    }
}