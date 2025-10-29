import java.util.*;
import java.io.*;

class Main {
    static int n, m;
    static char[][] board;
    static int[][] directions = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        
        int startX = 0, startY = 0;
        board = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            String ip = br.readLine();
            for (int j = 0; j < m; j++) {  
                board[i][j] = ip.charAt(j);
                if (board[i][j] == '0') {
                    startX = i;
                    startY = j;
                    board[i][j] = '.';
                }
            }
        }
        
        System.out.println(bfs(startX, startY));
    }
    
    private static int bfs(int x, int y) {
        Deque<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        
        q.add(x + "," + y + ",0,");  
        visited.add(x + "," + y + ",");
        
        while (!q.isEmpty()) {
            String[] curr = q.poll().split(",", -1);  
            int cx = Integer.parseInt(curr[0]);
            int cy = Integer.parseInt(curr[1]);
            int dist = Integer.parseInt(curr[2]);
            String keys = curr[3];  
            
            if (board[cx][cy] == '1') return dist;
            
            for (int[] d : directions) {
                int nx = d[0] + cx;
                int ny = d[1] + cy;
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                char cell = board[nx][ny];
                if (cell == '#') continue;
                
                // 문인데 열쇠가 없는 경우
                if (cell >= 'A' && cell <= 'F') {
                  char key = (char) (cell - 'A' + 'a');
                  if (keys.indexOf(key) == -1) continue;
                }

                // 열쇠 획득
                String newKeys = keys;
                if (cell >= 'a' && cell <= 'f' && keys.indexOf(cell) == -1) {
                    newKeys = sortedKeys(keys, cell);
                }
                
                String visitKey = nx + "," + ny + "," + newKeys;
                if (visited.contains(visitKey)) continue;
                visited.add(visitKey);
                
                q.add(nx + "," + ny + "," + (dist + 1) + "," + newKeys);
            }
        }
        
        return -1;
    }
    
    private static String sortedKeys(String keys, char k) {
        String nk = keys + k;
        char[] arr = nk.toCharArray();
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || arr[i] != arr[i-1]) sb.append(arr[i]);  
        }
        
        return sb.toString();
    }
}