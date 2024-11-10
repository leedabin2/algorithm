import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;

        List<int[]> groups = new ArrayList<>();
        int total = picks[0] + picks[1] + picks[2];
        int maxMinerals = Math.min(total * 5, minerals.length);
        for (int i = 0; i < minerals.length; i+=5) {
            int[] group = new int[3];
            for (int j = i;  i + 5 > j && j < maxMinerals; j++) {
                if(minerals[j].equals("diamond")) {
                    group[0] += 1;
                    group[1] += 5;
                    group[2] += 25;
                } else if (minerals[j].equals("iron")) {
                    group[0] += 1;
                    group[1] += 1;
                    group[2] += 5;
                } else {
                    group[0] += 1;
                    group[1] += 1;
                    group[2] += 1;
                }
            }
            groups.add(group);
        }
        
        groups.sort((a,b) -> b[2] - a[2]);
        for (int[] group : groups) {
            if (picks[0] > 0) {
                answer += group[0];
                picks[0]--;
            } else if (picks[1] > 0) { 
                answer += group[1];
                picks[1]--;
            } else if (picks[2] > 0) { 
                answer += group[2];
                picks[2]--;
            } else { 
                break;
            }
        }

        return answer;
    }
}
