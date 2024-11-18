class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1; 
        int currIndex = 1; 
        int index = 0; 

        while(currIndex <= n) {
            if (index < stations.length && stations[index] - w <= currIndex) {
                currIndex = stations[index] + w + 1;
                index++;
            } else {
                answer++;
                currIndex += range;
            }
        }

        return answer;
    }
}