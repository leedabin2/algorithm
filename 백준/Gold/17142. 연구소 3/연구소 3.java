import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    static int[][] board;
    static List<int[]> virusList = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 2) virusList.add(new int[]{i,j});
            }
        }

        dfs(0, 0, new ArrayList<>());

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void dfs(int idx, int cnt, List<int[]> selected) {
        if (cnt == M) {
            answer = Math.min(answer, spreadVirus(selected));
            return;
        }

        if (idx >= virusList.size()) return;

        selected.add(virusList.get(idx));
        dfs(idx+1, cnt+1, selected);


        selected.remove(selected.size()-1);
        dfs(idx+1, cnt, selected);
    }

    private static int spreadVirus(List<int[]> selected) {
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[N][N];

        for (int[] d : dist) Arrays.fill(d, -1);

        for (int[] virus : selected) {
            int x = virus[0], y = virus[1];
            queue.add(new int[]{x, y});
            dist[x][y] = 0;
        }

        int maxTime = 0;
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cx = curr[0], cy = curr[1];

            for (int[] dir : directions) {
                int nx = dir[0] + cx, ny = dir[1]+ cy;

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (board[nx][ny] == 1) continue;
                    if (dist[nx][ny] == -1) {
                        dist[nx][ny] = dist[cx][cy] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j =0; j < N; j++) {
                if (board[i][j] == 0) {
                    if (dist[i][j] == -1) return Integer.MAX_VALUE;
                    maxTime = Math.max(maxTime, dist[i][j]);
                }
            }
        }
        return maxTime;
    }
}
