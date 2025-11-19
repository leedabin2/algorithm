class Solution {
    static int m, n;
    static char[][] map;
    public int solution(int m, int n, String[] board) {
        int total = 0;
        
        
        this.m = m;
        this.n = n;
        map = new char[m][n];
        
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        while(true) {
            boolean[][] remove = new boolean[m][n];
            
            int count = findBlocks(remove);
            
            if (count == 0) break;
            
            total += count;
            removeBlocks(remove);
            dropBlocks();

        }
        return total;
    }
    static int findBlocks(boolean[][] remove) {
        int cnt = 0;
        
        for (int x = 0; x < m-1; x++) {
            for (int y = 0; y < n-1; y++) {
                char c = map[x][y];
                
                if (c == '*') continue;
                
                if (c == map[x+1][y] &&
                   c == map[x][y+1] &&
                   c == map[x+1][y+1]) {
                    
                    if (!remove[x][y]) {remove[x][y] = true; cnt++;}
                    if (!remove[x+1][y]) { remove[x+1][y] = true; cnt++; }
                    if (!remove[x][y+1]) { remove[x][y+1] = true; cnt++; }
                    if (!remove[x+1][y+1]) { remove[x+1][y+1] = true; cnt++; }
                }
            }
        }
        
        return cnt;
    }
    static void removeBlocks(boolean[][] remove){
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (remove[x][y]) {
                    map[x][y] = '*';
                }
            }
        }
    }
    static void dropBlocks() {
        for (int y = 0; y < n; y++) {
            int write = m-1;
            
            for (int x = m-1; x >= 0; x--) {
                if (map[x][y] != '*') {
                    map[write][y] = map[x][y];
                    if (write != x) map[x][y] = '*';
                    write--;
                }
            }
        }
    }
 
}