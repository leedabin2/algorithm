class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
        int max = (n / w) + 1;
        int[][] board = new int[max][w];
        int cnt = 1;

        for (int i = max - 1; i >= 0; i--) {
            if (i % 2 == 0) {
                for (int j = 0; j < w && cnt <= n; j++) {
                    board[i][j] = cnt++;
                }
            } else {
                for (int j = w - 1; j >= 0 && cnt <= n; j--) {
                    board[i][j] = cnt++;
                }
            }
        }

        int outI = 0, outJ = 0;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == num) {
                    outI = i;
                    outJ = j;
                }
            }
        }

        int curJ = outJ; // 현재 열 위치
        for (int i = outI - 1; i >= 0; i--) {
            // 위 층에서의 열 방향 고려
            if (i % 2 == 0) {
                curJ = outJ;
            } else {
                curJ = w - 1 - outJ;
            }

            if (curJ >= 0 && curJ < w && board[i][curJ] != 0) {
                answer++;
            }
        }

        return answer;
    }
}
