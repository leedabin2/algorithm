import java.util.*;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
       
        List<int[]> answer = new ArrayList<>();
        for (int[] b : build_frame) {
            if(b[3] == 1){
                answer.add(new int[]{b[0],b[1],b[2]});
                if(!check(answer)) {
                     answer.remove(answer.size()-1);
                }
            }
         
            if (b[3] == 0) {
                answer.removeIf(a -> a[0] == b[0] && a[1] == b[1] && a[2] == b[2]);
                if(!check(answer)) {
                     answer.add(new int[]{b[0],b[1],b[2]});
                }
            }

        }
        return answer.stream()
                     .sorted((a, b) -> {
                         if (a[0] != b[0]) return a[0] - b[0];
                         if (a[1] != b[1]) return a[1] - b[1];
                         return a[2] - b[2];
                     })
                     .toArray(int[][]::new);
    }
    private boolean check(List<int[]> answer) {
        for (int[] a : answer) {
            int x =  a[0];
            int y = a[1];
            int r = a[2];
            if (r == 0) {
                // 바닥인경우, 밑이 기둥인 경우, 보의 한쪽끝인 경우
                if (y == 0 || contains(answer,x,y-1,0) || contains(answer,x-1,y,1) || contains(answer, x, y, 1)) {
                    continue;
                }
                return false;
            }
            if (r == 1 ) {
                 if (contains(answer, x, y - 1, 0) || contains(answer, x + 1, y - 1, 0) || 
                   (contains(answer, x - 1, y, 1) && contains(answer, x + 1, y, 1))) {
                    continue;
                }
                return false;  
            }
        }
        return true;
        
    }
    private boolean contains(List<int[]> answer, int x, int y, int type) {
        for (int[] a : answer) {
            if (a[0] == x && a[1] == y && a[2] == type) {
                return true;
            }
            
        }
        return false;
    }
}