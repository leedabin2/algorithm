import java.util.*;
import java.io.*;

class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> reverse = new HashMap<>();

        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(i, name);          // 번호 → 이름
            reverse.put(name, i);      // 이름 → 번호
        }

        for (int i = 0; i < M; i++) {
            String cmd = br.readLine();

            // cmd가 숫자인지 판별
            boolean isNumber = true;
            for (char c : cmd.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isNumber = false;
                    break;
                }
            }

            if (isNumber) { 
                int num = Integer.parseInt(cmd);
                sb.append(map.get(num)).append("\n");
            } else { 
                sb.append(reverse.get(cmd)).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
