class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        int w = total / 2; // 가로

        while (w > 0) {
            int h = total / w;
            if (w < h) {
                break;
            }
            if ((w * h) == total) {
                int yellowCount = (w-2) * (h-2);
                if (yellowCount == yellow) {
                    answer = new int[]{w,h};
                    break;
                }    
            }
            w--;
        }

        return answer;
    }
}