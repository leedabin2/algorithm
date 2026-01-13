import java.util.*;

class Solution {
    static int N;
    static int answer =0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(int[][] board) {
        N = board.length;
        
        // 행이 같으면 가로 , 열이 같으면 세로
        List<int[]> robot = new ArrayList<>();
        robot.add(new int[]{0, 0, 0, 1});
        return bfs(robot, board);
    }
    static int bfs(List<int[]> robot, int[][] board) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[N][N][N][N];
        int x1 =robot.get(0)[0];
        int y1 = robot.get(0)[1];
        int x2= robot.get(0)[2];
        int y2 = robot.get(0)[3];
        q.add(new int[]{x1, y1, x2, y2, 0});
        visited[x1][y1][x2][y2] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int cx1 = cur[0];
            int cy1 = cur[1];
            int cx2 = cur[2];
            int cy2 = cur[3];
            int time = cur[4];
            
            if ((cx1 == N-1 && cy1 == N-1) ||
               (cx2 == N-1 && cy2 == N-1)) {
                return time;
            }
            
            // 1상하좌우
            for (int d = 0; d < 4; d++) {
                int nx1 = dx[d] + cx1;
                int ny1 = dy[d] + cy1;
                int nx2 = dx[d] + cx2;
                int ny2 = dy[d] + cy2;
                
                if (nx1 < 0 || nx2 < 0 || ny1 < 0 || ny2 < 0) continue;
                if (nx1 >= N || nx2 >= N || ny1 >= N || ny2 >= N) continue;
                if (visited[nx1][ny1][nx2][ny2]) continue;
                if (board[nx1][ny1] == 1 || board[nx2][ny2] == 1) continue;
                
                visited[nx1][ny1][nx2][ny2] = true;
                q.add(new int[]{nx1, ny1, nx2, ny2, time+1});
            }
            
            // 2회전
            // 가로일때
            if (cx1 == cx2) {
                for (int dir : new int[]{-1 , 1}) {
                    int rx1 = cx1 + dir;
                    int ry1 = cy1;
                    int rx2 = cx2 + dir;
                    int ry2 = cy2;
                    if (rx1 < 0 || rx2 < 0 || rx1 >= N || rx2 >= N) continue;
                    if (board[rx1][ry1] == 1 || board[rx2][ry2] == 1) continue;
                    
                    if (!visited[cx1][cy1][rx1][ry1]) {
                        visited[cx1][cy1][rx1][ry1] = true;
                        q.add(new int[]{cx1, cy1, rx1, ry1, time+1});
                    }
                    if (!visited[cx2][cy2][rx2][ry2]) {
                        visited[cx2][cy2][rx2][ry2] = true;
                        q.add(new int[]{cx2, cy2, rx2, ry2, time + 1});
                    }
                }
            }
            
            // 세로일때
            else if (cy1 == cy2) {
                for (int dir : new int[]{-1, 1}) {
                    int rx1 = cx1;
                    int ry1 = cy1 + dir;
                    int rx2 = cx2;
                    int ry2 = cy2 + dir;
                    
                    if (ry1 < 0 || ry2 < 0 || ry1 >= N || ry2 >= N) continue;
                    if (board[rx1][ry1] == 1 || board[rx2][ry2] == 1) continue;
                    
                    if (!visited[cx1][cy1][rx1][ry1]) {
                        visited[cx1][cy1][rx1][ry1] = true;
                        q.add(new int[]{cx1, cy1, rx1, ry1, time + 1});
                    }
                    if (!visited[cx2][cy2][rx2][ry2]) {
                        visited[cx2][cy2][rx2][ry2] = true;
                        q.add(new int[]{cx2, cy2, rx2, ry2, time + 1});
                    }
                }
            }
            
             
        }
        return 0;
        
    }
}