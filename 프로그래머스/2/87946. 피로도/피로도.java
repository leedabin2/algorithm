class Solution {
    int maxDungeonsCount = 0;
    public int solution(int k, int[][] dungeons) {
      
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited);
        return maxDungeonsCount;
    }
    private void dfs(int curr, int[][] dungeons, int count, boolean[] visited) {

        maxDungeonsCount = Math.max(maxDungeonsCount,count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int pirodo = dungeons[i][0];
            int minusPirodo = dungeons[i][1];
            
            if (!visited[i] && curr >= pirodo) {
                visited[i] = true;
                dfs(curr-minusPirodo, dungeons, count + 1, visited);
                visited[i] = false;
            }
        } 
    }
}