import java.util.*;

class Solution {
    public int[] solution(int n, int[] info) {
        int maxDiff = -1;
        int[] answer = new int[11];
        Deque<Object[]> q = new ArrayDeque<>();
        q.offer(new Object[]{0,n,0,0,new int[11]});
        
        while(!q.isEmpty()) {
            Object[] curr = q.poll();
            int index = (int) curr[0];
            int arrowsLeft = (int) curr[1];
            int lionScore =(int) curr[2];
            int apeachScore = (int)curr[3];
            int[] lion = (int[]) curr[4];
            
            
            if (index == 11) {
                
                if (arrowsLeft > 0) { 
                    lion[10] += arrowsLeft;
                }
             
                int scoreDiff = lionScore - apeachScore;
                
                if (scoreDiff > maxDiff  && scoreDiff > 0) {
                    maxDiff = scoreDiff;
                    answer= lion.clone();
                } else if (scoreDiff == maxDiff  && scoreDiff > 0) {
                    for (int i = 10; i>=0 ; i--) {
                        if (lion[i] > answer[i]) {
                            answer = lion.clone();
                            break;
                        } else if (lion[i] < answer[i]) {
                            break;
                        }
                    }
                }
                continue;
            }
            
            // 라이언이 이기게 하는 경우
            if (arrowsLeft > info[index]) {
                int[] lionCopy = lion.clone();
                lionCopy[index] = info[index] + 1;
                q.offer(new Object[]{index+1,arrowsLeft - lionCopy[index], lionScore + (10-index), apeachScore, lionCopy});
            }
            
            int apeachWin = (info[index] > 0) ? (10-index) : 0;
            q.offer(new Object[]{index+1,arrowsLeft,lionScore,apeachScore + apeachWin, lion.clone() });
            
        }
        
        return maxDiff > 0 ? answer : new int[]{-1};
    }
}