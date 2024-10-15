import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] c : commands) {
            int i= c[0]-1;
            int j = c[1];
            int k = c[2];
            int[] array2 = Arrays.copyOfRange(array,i,j);
            Arrays.sort(array2);
            answer.add(array2[k-1]);
            
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}