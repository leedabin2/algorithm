import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;


        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int dist = r[2];
            
            if (!map.containsKey(a)) {
                map.put(a,new HashMap<>());
            }
            
            if (!map.get(a).containsKey(b) || map.get(a).get(b) > dist) {
                map.get(a).put(b, dist);
            }
            
            if (!map.containsKey(b)) {
                map.put(b,new HashMap<>());
            }
            
            if (!map.get(b).containsKey(a) || map.get(b).get(a) > dist) {
                map.get(b).put(a, dist);
            }
            
        }
        // System.out.println(map);

        Set<Integer> result = new HashSet<>();
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{1,0});
        int[] minDist = new int[N+1];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[1] = 0;
        result.add(1);
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currNode = curr[0];
            int dist = curr[1];
       
            
            for (Map.Entry<Integer,Integer> entry : map.get(currNode).entrySet()) {
                int nextNode = entry.getKey();
                int value = entry.getValue();
                int newDist = value + dist;
                
                 if ( newDist < minDist[nextNode] && newDist <= K) {
                    minDist[nextNode] = newDist;
                    q.offer(new int[]{nextNode, newDist});
                    result.add(nextNode);
                }
            }
        }
        
        // System.out.println(result);
        answer = result.size();
        
        return answer;
    }
}