import java.util.*;

class Solution {
    static int n;
    static int maxScore = 0;
    static int[] answer;
    public int[] solution(int[][] dice) {
        
        n = dice.length;
        answer = new int[n/2];
        
        dfs(0, dice, new ArrayList<>());
        
        return answer;
    }
    static void dfs(int start, int[][] dice, List<Integer> idx) {
        if (idx.size() == (n/2)) {
            calcScore(idx, dice);
            return;
        }
        
        for (int i = start; i < n; i++) {
            idx.add(i);
            dfs(i+1, dice, idx);
            idx.remove(idx.size()-1);
        }
    }
    
    static void calcScore(List<Integer> idx , int[][] dice) {
        // a주사위로 만들 수 있는 모든합, b 주사위로 만드는 모든 합
        // 합을 비교해서 이긴 횟수 계산
        // maxScore 갱신
        
        List<Integer> aIdx = new ArrayList<>(idx);
        List<Integer> bIdx = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!aIdx.contains(i)) bIdx.add(i);
        }
        
        List<Integer> aSum = new ArrayList<>();
        List<Integer> bSum = new ArrayList<>();
        
        makeSum(aIdx, dice, 0, 0, aSum);
        makeSum(bIdx, dice, 0, 0, bSum);
        
        Collections.sort(aSum);
        Collections.sort(bSum);
        
        int win = 0;
        int j = 0;
        for (int i = 0; i < aSum.size(); i++) {
            while (j < bSum.size() && bSum.get(j) < aSum.get(i)) {
                j++;
            }
            win += j;
        }
        
        if (win > maxScore) {
            maxScore = win;
            int id = 0;
            for (int i : aIdx) {
                answer[id++] = i+1; 
            }
        }
    }
    static void makeSum(List<Integer> idx, int[][] dice, int depth, int sum, List<Integer> result) {
        if (depth == idx.size()) {
            result.add(sum);
            return;
        }
        
        int[] cur = dice[idx.get(depth)];
        for (int i = 0; i < 6; i++) {
            makeSum(idx, dice, depth + 1, sum + cur[i], result);
        }
    }
}