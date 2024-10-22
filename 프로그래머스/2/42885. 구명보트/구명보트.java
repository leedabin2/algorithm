import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        int light = 0;
        int heavy = people.length - 1;
        Arrays.sort(people);
        
        while (light <= heavy) {
            if (people[light] + people[heavy] <= limit) {
                light++;
            }
            heavy--;
            answer++;
        }
        
        return answer;
    }
}