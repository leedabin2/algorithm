import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 5개의 대기실에 대해 검사
        for (int i = 0; i < 5; i++) {
            boolean isSafe = true; 
            
         
            for (int x = 0; x < 5 && isSafe; x++) {
                for (int y = 0; y < 5 && isSafe; y++) {
                    if (places[i][x].charAt(y) == 'P') {
                       
                        if (!check(x, y, places[i])) {
                            isSafe = false;  
                        }
                    }
                }
            }
            answer[i] = isSafe ? 1 : 0;  
        }
        return answer;
    }
    

    private boolean check(int x, int y, String[] places) {
     
        int[][] dist = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        // 1칸 거리 확인
        for (int[] d : dist) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            
          
            if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5) {
             
                if (places[nextX].charAt(nextY) == 'P') {
                    return false;
                }
                
                // 1칸 거리가 빈 자리일 경우, 2칸 거리 확인
                if (places[nextX].charAt(nextY) == 'O') {
                   
                    for (int[] dd : dist) {
                        int nx = nextX + dd[0];
                        int ny = nextY + dd[1];
                        
                    
                        if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                           
                            if (nx == x && ny == y) continue;
                         
                            if (places[nx].charAt(ny) == 'P') {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
