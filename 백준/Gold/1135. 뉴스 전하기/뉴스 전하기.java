import java.io.*;
import java.util.*;

class Main {
    static int n;
    static List<List<Integer>> tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        
        String[] st = br.readLine().split(" ");
        
        int r = 0;
        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(st[i]);
            if (p == -1) r = i;
            else tree.get(p).add(i);
        }
        
        System.out.println(dfs(r));
        
    }
    
    static int dfs(int node) {
        
        List<Integer> times = new ArrayList<>();
        for (int ch : tree.get(node)) times.add(dfs(ch));
        times.sort(Collections.reverseOrder());
        
        int max = 0;
        for (int i = 0; i < times.size(); i++) {
            max = Math.max(max, times.get(i) + i + 1);
        }
        return max;
        
    }
}