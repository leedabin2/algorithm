import java.util.*;
import java.io.*;
class Main {
    static List<List<Integer>> graph;
    static Deque<Integer> queue;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        
        graph = new ArrayList<>();
        queue = new ArrayDeque<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < M; i++) {
            String[] row = br.readLine().split(" ");
            
            int a = Integer.parseInt(row[0])-1;
            int b = Integer.parseInt(row[1])-1;
            
            graph.get(a).add(b);
            graph.get(b).add(a);
            
        }
        
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }
        
        System.out.println(answer);
    }
    static void bfs(int start) {
        
        queue.add(start);
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (visited[curr]) continue;
            visited[curr] = true;
            
            for (int next : graph.get(curr)) {
                if (!visited[next]) {
                    queue.add(next);
                }
            }
        }
    }
}