import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }

            sb.append(check(arr) ? "YES\n" : "NO\n");
        }

        System.out.print(sb);
    }

    static boolean check(int[] arr) {
        return canFold(arr, true) || canFold(arr, false);
    }

    static boolean canFold(int[] arr, boolean upOdd) {
        int n = arr.length;
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) pos[arr[i]] = i; 

        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        for (int page = 1; page <= n; page++) {
            int p = pos[page];
            boolean facingUp = ((p % 2 == 0) == upOdd); 

            // 왼쪽 이웃
            if (p > 0) {
                int neighbor = arr[p - 1];
                if (!processEdge(page, neighbor, facingUp ? left : right)) return false;
            }

            // 오른쪽 이웃
            if (p + 1 < n) {
                int neighbor = arr[p + 1];
                if (!processEdge(page, neighbor, facingUp ? right : left)) return false;
            }
        }

        return left.isEmpty() && right.isEmpty();
    }

    static boolean processEdge(int page, int neighbor, Deque<Integer> stack) {
        if (page < neighbor) {
            stack.push(page); // 위쪽 끝에서 열기
        } else {
            if (stack.isEmpty() || stack.peek() != neighbor) return false;
            stack.pop(); // 가장 최근에 연 선을 닫기
        }
        return true;
    }
}
