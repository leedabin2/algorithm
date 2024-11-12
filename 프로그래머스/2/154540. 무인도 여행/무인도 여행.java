import java.util.*;
class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
      
    
        int[][] dist = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    int total = bfs(visited, dist, maps, i, j);
                    result.add(total);
                }
            }
        }
        if (result.isEmpty()) {
             return new int[]{-1};
        }
        Collections.sort(result); 
        return result.stream().mapToInt(i -> i).toArray();
    }
    private int bfs(boolean[][] visited, int[][] dist, String[] maps, int x, int y){
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        int cost = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currX = curr[0];
            int currY = curr[1];
            
            char currChar = maps[currX].charAt(currY);
            if (Character.isDigit(currChar)) {
                cost += Integer.parseInt(String.valueOf(currChar));
            }

            for (int[] d : dist) {
                int nextX = d[0] + currX;
                int nextY = d[1] + currY;
                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length()) {
                    continue;
                }
                if (!visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
                  
                    visited[nextX][nextY] = true;
                    q.offer(new int[]{nextX,nextY});
                } 
            }
        }
        return cost;
        
    }
}