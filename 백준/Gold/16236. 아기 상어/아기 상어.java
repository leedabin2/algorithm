import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int[][] board;
    static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int sharkX = 0, sharkY = 0;
        
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(row[j]);
                if (board[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;
                    board[i][j] = 0;
                }
            }
        }
        
        int sharkSize = 2;
        int totalTime = 0;
        int eatCount = 0;
        
        while(true) {
            // 먹을 수 있는 물고기 찾기
            int[][] dist = new int[N][N];
            for (int[] d : dist) Arrays.fill(d, -1);
            
            dist[sharkX][sharkY] = 0;
            Deque<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{sharkX, sharkY});
            
            List<int[]> candidates = new ArrayList<>();
            int minDist = Integer.MAX_VALUE;
            
            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                int cx = curr[0], cy = curr[1];
                
                if (dist[cx][cy] > minDist) break;
                
                // 먹을 수 있는 물고기 확인
                if (board[cx][cy] > 0 && board[cx][cy] < sharkSize) {
                    if (dist[cx][cy] < minDist) {
                        minDist = dist[cx][cy];
                        candidates.clear();
                        candidates.add(new int[]{cx, cy, dist[cx][cy]});
                    } else if (dist[cx][cy] == minDist) {
                        candidates.add(new int[]{cx, cy, dist[cx][cy]});
                    }
                }
                
                // 4방향 탐색
                for (int[] dir : directions) {
                    int nx = cx + dir[0], ny = cy + dir[1];
                    
                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (dist[nx][ny] == -1 && board[nx][ny] <= sharkSize) {
                            dist[nx][ny] = dist[cx][cy] + 1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
            

            if (candidates.isEmpty()) break; // 더 이상 먹을 물고기 없음
            
            // 우선순위 정렬
            candidates.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                return a[1] - b[1];
            });
            
            // 물고기 먹기
            int[] target = candidates.get(0);
            int fishX = target[0], fishY = target[1];
            int fishDist = target[2];
            
            board[fishX][fishY] = 0;
            sharkX = fishX;  
            sharkY = fishY;
            totalTime += fishDist;
            eatCount++;
            
            if (eatCount == sharkSize) {
                sharkSize++;
                eatCount = 0;
            }
        }
        
        System.out.println(totalTime);
    }
}