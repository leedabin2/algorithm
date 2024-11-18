import java.util.*;

class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};
        Map<Integer, Map<Integer,Integer>> graph = new HashMap<>();
        for (int[] p : paths) {
            int i = p[0];
            int j = p[1];
            int w = p[2];
            
            graph.computeIfAbsent(i, k -> new HashMap<>()).put(j,w);
            graph.computeIfAbsent(j, k -> new HashMap<>()).put(i,w);
        }
        
        Set<Integer> setSummits = new HashSet<>();
        for (int s : summits) setSummits.add(s);
        
        Set<Integer> setGates = new HashSet<>();
        for (int g : gates) setGates.add(g);
        
    
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] intensity = new int[n+1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        for (int gate : gates) {
            pq.offer(new int[]{gate,0});
            intensity[gate] = 0;
        }
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            
            if (setSummits.contains(node)) continue;
            if (cost > intensity[node]) continue;
            
            for (Map.Entry<Integer,Integer> entry : graph.getOrDefault(node, new HashMap<>()).entrySet()) {
                int next = entry.getKey();
                int w = entry.getValue();
                
                if (setGates.contains(next)) continue;
                
                int nextIntensity = Math.max(cost, w);
                if (nextIntensity < intensity[next]) {
                    intensity[next] = nextIntensity;
                    pq.offer(new int[]{next, nextIntensity});
                }
            }
            
            
        }
        
        // System.out.println(Arrays.toString(intensity));
        Arrays.sort(summits);
        int minSummitsNum = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        
        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minSummitsNum = summit;
                minIntensity = intensity[summit];
            }
        }
       
        
        
        return new int[]{minSummitsNum, minIntensity};
    }
}