import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for (int idx = 0; idx < 5; idx++) {
            String[] place = places[idx];
            
            boolean ok = true;
            
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        if(!isSafe(i,j,place)) {
                            ok = false;
                        }
                    }
                }
            }
            
            if (ok) answer[idx] = 1;            
            else answer[idx] = 0;
        }
        return answer;
    }
    
    private static boolean isSafe(int x, int y, String[] place) {
        int[][] directions = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        boolean[][] visited = new boolean[5][5];
        Deque<int[]> peoples = new ArrayDeque<>();
        peoples.add(new int[]{x,y,0});
        visited[x][y] = true;
        
        while(!peoples.isEmpty()) {
            int[] curr = peoples.poll();
            int cx = curr[0], cy = curr[1], dist = curr[2];
            
            if (dist >= 1 && place[cx].charAt(cy) == 'P') return false;
            if (dist == 2) continue;
            
            for (int[] dir : directions) {
                int nx = dir[0] + cx, ny = dir[1] + cy;
                if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && !visited[nx][ny]) {
                    if (place[nx].charAt(ny) != 'X') {
                        visited[nx][ny] = true;
                        peoples.add(new int[]{nx,ny,dist+1});
                    }
                }
            }
            
        }
        
        return true;
        
    }
}