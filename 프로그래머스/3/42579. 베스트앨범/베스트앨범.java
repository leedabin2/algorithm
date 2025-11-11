import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        List<Integer> answer = new ArrayList<>();
        
        Map<String, List<int[]>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            map.putIfAbsent(genre, new ArrayList<>());
            map.get(genre).add(new int[]{i, play });
        }
        
        
        Map<String, Integer> total = new HashMap<>();
        
        for (String g : map.keySet()) {
            
            int sum = 0;
            for (int[] songs : map.get(g)) {
                sum += songs[1];
            }
            
            total.put(g,sum);
        }
        
        List<String> getOrder = new ArrayList<>(map.keySet());
        getOrder.sort((a, b) -> total.get(b) - total.get(a));
        
        for (String g : map.keySet()) {
            map.get(g).sort((a, b) ->
                            {
                                if (b[1] != a[1]) return b[1] - a[1];
                                return a[0] - b[0];
                            });
        }
        
        
        for (String g : getOrder) {
            List<int[]> songs = map.get(g);
            
            for (int i = 0; i < songs.size() && i < 2; i++) {
                answer.add(songs.get(i)[0]);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}