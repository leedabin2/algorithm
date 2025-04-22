import java.util.*;

class Solution {
    public int[] solution(int[] answers) {

        int[] oneAnswer = {1,2,3,4,5};
        int[] twoAnswer = {2,1,2,3,2,4,2,5};
        int[] threeAnswer = {3,3,1,1,2,2,4,4,5,5};
        int n = answers.length;
        int one = 0;
        int two = 0;
        int three = 0;
        
        for (int i = 0; i < n; i++) {
            if (answers[i] == oneAnswer[i % oneAnswer.length ]) {
                one++;
            }
            if (answers[i] == twoAnswer[i % twoAnswer.length]) {
                two++;
            }
            if (answers[i] == threeAnswer[i % threeAnswer.length]) {
                three++;
            }
        }
        
        int maxWin = Math.max(one,Math.max(two,three));
        List<Integer> res = new ArrayList<>();
   
        if (maxWin == one) {
            res.add(1);
        }
        if (maxWin == two) {
            res.add(2);
        }
        if (maxWin == three) {
            res.add(3);
        }
            
        
        return res.stream().mapToInt(Integer::intValue).toArray();

        
    }
}