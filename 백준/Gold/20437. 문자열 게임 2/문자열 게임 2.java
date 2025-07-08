import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());

    while(T-- > 0) {
      String s = br.readLine();
      int K = Integer.parseInt(br.readLine());


      Map<Character,List<Integer>> map = new HashMap<>();
      for (int i = 0; i < s.length(); i++) {
        
        char c = s.charAt(i);
        map.putIfAbsent(c, new ArrayList<>());
        map.get(c).add(i);
      }

      int minLen = Integer.MAX_VALUE, maxLen = Integer.MIN_VALUE;
      for (char key : map.keySet()) {

        List<Integer> idxList = map.get(key);

        if (idxList.size() < K) continue;
        //
        for (int i = 0; i <= idxList.size()-K; i++) {
          int start = idxList.get(i);
          int end = idxList.get(i+K-1);
          int len = end - start + 1;

          minLen = Math.min(minLen, len);
          maxLen = Math.max(maxLen, len);
        }
      }

      if (minLen == Integer.MAX_VALUE) {
        System.out.println(-1);
      } else {
        System.out.println(minLen + " " + maxLen);
      }
    }
    
  }
} 