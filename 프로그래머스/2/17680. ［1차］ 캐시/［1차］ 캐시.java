import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        // 2 : 45
        
        // 앞에를 빼고, 뒤에 추가
        
        int time = 0;
        
        Deque<String> cache = new ArrayDeque<>();
        
        if (cacheSize == 0) {
            time = cities.length*5;
            return cities.length * 5;
        }
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.contains(city)) {
                cache.remove(city);
                cache.addLast(city);
                time+=1;
                
            } else {
                if (cache.size() == cacheSize) {
                    cache.removeFirst();
        
                }
                cache.addLast(city);
                time += 5;
            }
        }
        
        
        return time;
    }
}