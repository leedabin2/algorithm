class Solution {
    static final int SAT = 6;
    static final int SUN = 7;
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int n = schedules.length;
        // %7
        
        int[] pass = new int[n];
        for (int i = 0; i < n; i++) {
            int add = (schedules[i] + 10);
            if (add % 100 >= 60) {
                add += 40;
            }
            pass[i] = add;
        }
        
        
        for (int i = 0; i < n; i++) {
            int[] logs = timelogs[i];
            boolean ok = true;
            for (int j = 0; j < 7; j++) {
                // 이벤트 포함 하지 않는 날짜
                int weekday = (startday + j-1) % 7 + 1;
                if (weekday == SAT || weekday == SUN) continue;
                // 출근 인정 시각보다 늦게 출근한 경우
                if (pass[i] < logs[j]) {
                    ok = false;
                    break;
                }
  
            }
            if (ok) answer++;
            
        }
        return answer;
    }
}