class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        boolean[][] graph = new boolean[n+1][n+1];
        for (int[] result: results) {
            int winNum = result[0];
            int loseNum = result[1];
            
            graph[winNum][loseNum] = true;
        }
    
        for (int k = 1; k < n+1; k++) {
            for (int i = 1; i <n+1; i++) {
                for (int j = 1; j <n+1; j++) {
                    if(graph[i][k] && graph[k][j]) { 
                        graph[i][j] = true;
                    }
                }
            }
        }
      
  
   
        for (int i= 1; i < n+1; i++) {
            int count = 0;
            for (int j = 1; j < n+1; j++) {
                if (graph[i][j] || graph[j][i]) {
                    count++;
                }
            }
            if (count == n-1) {
                answer++;
            }
        }
        
        
        return answer;
    }
}