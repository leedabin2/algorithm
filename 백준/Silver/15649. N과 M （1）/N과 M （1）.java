import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] visited;
    static List<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] cmd = br.readLine().split(" ");
        N = Integer.parseInt(cmd[0]);
        M = Integer.parseInt(cmd[1]);

        visited = new int[N + 1];
        res = new ArrayList<>();

        dfs(0);
    }

    private static void dfs(int idx) {
        if (idx == M) {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i));
                if (i != res.size() - 1) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                res.add(i);
                dfs(idx + 1);
                res.remove(res.size() - 1);
                visited[i] = 0;
            }
        }
    }
}
