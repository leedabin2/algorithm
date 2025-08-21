import java.util.*;

class Solution {
    static int maxCount = 0;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        // 1 : 51 
        dfs(k,dungeons,0);
        return maxCount;
    }
    static private void dfs(int curr, int[][] dungeons, int count) {
        maxCount = Math.max(maxCount, count);
        
        for (int i =0; i < dungeons.length; i++) {
            if (!visited[i]) {
                int need = dungeons[i][0];   // 최소 필요 피로도
                int cost = dungeons[i][1];   // 소모 피로도
                if (need <= curr) {
                    visited[i] = true;
                    dfs(curr - cost, dungeons, count + 1);
                    visited[i] = false;
                }
            }
        }
        
        
    }
}