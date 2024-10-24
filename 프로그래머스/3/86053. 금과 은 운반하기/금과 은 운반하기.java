class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 0;
        long right = (long) 4e14;
        long answer = right;
        // mid시간동안 이동할 수 있는 편도 횟수 계산하기 ->
        // 왕복 횟수를 계산하고 편도가 가능하면 1회 추가
        while (left <= right) {
            long mid = (left + right) / 2;
            long totalGold = 0;
            long totalSilver = 0;
            long totalMineral = 0;
            
            for (int i = 0; i < g.length; i++) {
              
                long movement = mid / t[i];
                
                long moveCount = movement / 2;
                if (movement % 2 == 1) {
                    moveCount++;
                }
                
                long maxWeight = moveCount * w[i];
                
                totalGold += Math.min(g[i], maxWeight);
                totalSilver += Math.min(s[i], maxWeight);
                totalMineral += Math.min(g[i] + s[i], maxWeight);
            }
            
            if (totalGold >= a && totalSilver >= b && totalMineral >= a + b) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}