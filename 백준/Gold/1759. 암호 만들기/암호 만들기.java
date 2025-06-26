import java.util.*;
import java.io.*;

class Main {
  static int L, C;
  static String[] locks;
  static String[] result;
  static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    String[] st = br.readLine().split(" ");
    L = Integer.parseInt(st[0]);
    C = Integer.parseInt(st[1]);


    locks = new String[C];
    String[] row = br.readLine().split(" ");
    for (int i = 0; i < C; i++) locks[i] = row[i];
    
    Arrays.sort(locks);

    result = new String[L];

    dfs(0,0);
  }
  static void dfs(int depth, int start) {
    if (depth == L) {
      // 모음 1개 이상, 자음 2개 이상
      if (isValid(result)) {
        for (int i = 0; i < L; i++) {
          System.out.print(result[i]);
        }
        System.out.println();
      }
      return;
    }

    for (int i = start; i < C; i++) {
      result[depth] = locks[i];
      dfs(depth + 1, i + 1);
    }
  }

  static boolean isValid(String[] result) {
    int vowelCount = 0;
    int consonantCount = 0;
    for (String re : result) {
      if (vowels.contains(re.charAt(0))) vowelCount++;
      else consonantCount++;
    }

    return vowelCount >= 1 && consonantCount >= 2;
  }
} 