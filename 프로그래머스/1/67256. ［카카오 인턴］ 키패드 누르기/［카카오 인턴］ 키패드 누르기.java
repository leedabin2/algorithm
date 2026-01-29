import java.util.*;

class Solution {
    static int[][] pos = {
        {3, 1},
        {0,0}, {0,1},{0,2},
        {1,0},{1,1},{1,2},
        {2,0},{2,1},{2,2},
        {3,0},{3,1},{3,2}
    };
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        int[] left = {3,0};
        int[] right = {3,2};
        for (int num : numbers) {
            if (num == 1 || num == 4 || num == 7) {
                left = pos[num];
                sb.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                right = pos[num];
                sb.append("R");
            } else {
                int[] target = pos[num];
                int leftDist = Math.abs(left[0] - target[0]) + Math.abs(left[1] - target[1]);
                int rightDist = Math.abs(right[0] - target[0]) + Math.abs(right[1] - target[1]);
                if (leftDist > rightDist) {
                    right = target;
                    sb.append("R");
                } else if (leftDist < rightDist) {
                    left = target;
                    sb.append("L");
                } else if (leftDist == rightDist) {
                    if (hand.equals("right")) {
                        right = target;
                        sb.append("R");
                    } else {
                        left = target;
                        sb.append("L");
                    }
                }
            }
        }
        
        
    
        
        
        return sb.toString();
    }
}