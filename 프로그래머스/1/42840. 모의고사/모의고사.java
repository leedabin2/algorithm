import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {0,0,0};
        
        int[] answer1 = {1,2,3,4,5};
        int[] answer2 = {2,1,2,3,2,4,2,5};
        int[] answer3 = {3,3,1,1,2,2,4,4,5,5};
        
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == answer1[i % answer1.length]) {
                answer[0]++;
            } 
            if (answers[i] == answer2[i % answer2.length]) {
                answer[1]++;
            }
            if (answers[i] == answer3[i % answer3.length]) {
                answer[2]++;
            }
        }
    
        int maxScore = Math.max(answer[0], Math.max(answer[1], answer[2]));
    
        List<Integer> top = new ArrayList<>();
        if (answer[0] == maxScore) top.add(1);
        if (answer[1] == maxScore) top.add(2);
        if (answer[2] == maxScore) top.add(3);
        
        return top.stream().mapToInt(i->i).toArray();
    }
}