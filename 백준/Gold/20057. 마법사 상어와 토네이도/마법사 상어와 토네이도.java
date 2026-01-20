import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static int[] dx = {0, 1, 0, -1}; // ← ↓ → ↑
    static int[] dy = {-1, 0, 1, 0};

    // 왼쪽 방향 기준 모래 퍼짐 {x, y, 비율}
    static int[][] sandPercent = {
        {-1, 1, 1}, {1, 1, 1},
        {-1, 0, 7}, {1, 0, 7},
        {-1, -1, 10}, {1, -1, 10},
        {-2, 0, 2}, {2, 0, 2},
        {0, -2, 5}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }

        int outSand = 0;
        int x = N / 2, y = N / 2; // 시작 위치
        int dir = 0;
        int move = 1;

        while (true) {
            for (int d = 0; d < 2; d++) {
                for (int i = 0; i < move; i++) {
                    x += dx[dir];
                    y += dy[dir];

                    outSand += spread(x, y, dir);

                    if (x == 0 && y == 0) {
                        System.out.println(outSand);
                        return;
                    }
                }
                dir = (dir + 1) % 4;
            }
            move++;
        }
    }

    static int spread(int x, int y, int dir) {
        int sand = board[x][y];
        int spreadTotal = 0;
        int out = 0;

        board[x][y] = 0;

        for (int[] s : sandPercent) {
            int[] rotated = rotate(s[0], s[1], dir);
            int nx = x + rotated[0];
            int ny = y + rotated[1];
            int amount = sand * s[2] / 100;

            spreadTotal += amount;
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                out += amount;
            } else {
                board[nx][ny] += amount;
            }
        }

        // 남은 모래
        int ax = x + dx[dir];
        int ay = y + dy[dir];
        int alpha = sand - spreadTotal;
        if (ax < 0 || ay < 0 || ax >= N || ay >= N) {
            out += alpha;
        } else {
            board[ax][ay] += alpha;
        }

        return out;
    }

    // 방향에 따라 좌표 회전 
    static int[] rotate(int r, int c, int dir) {
        for (int i = 0; i < dir; i++) {
            int tmp = r;
            r = -c;
            c = tmp;
        }
        return new int[]{r, c};
    }
}
