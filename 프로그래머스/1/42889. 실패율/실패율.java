import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        List<Integer> answer = new ArrayList<>();
        int players = stages.length;
        // {실패율, 스테이지번호}
        double[][] fail = new double[N][2]; // {실패율, 스테이지번호}
        
        
    
        Map<Integer, Integer> failMap = new HashMap<>();
        for (int stage : stages) {
            failMap.put(stage, failMap.getOrDefault(stage, 0) + 1);
        }
        
        for (int stage = 1; stage <= N; stage++) {
            int player = failMap.getOrDefault(stage, 0);
            double failRate = players == 0 ? 0.0 : (double) player / players;
            
            fail[stage-1][0] = failRate;
            fail[stage-1][1] = stage;
            
            players -= player;
        }
        
        Arrays.sort(fail, (a, b) -> {
            if (Double.compare(a[0], b[0]) != 0) return Double.compare(b[0], a[0]); // 실패율 내림차순
            else return Double.compare(a[1], b[1]); //실패율이 같으면 스테이지 번호 오름차순
        });
        
        for (double[]  f : fail) {
            int stage = (int) f[1];
            
            answer.add(stage);
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}