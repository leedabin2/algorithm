import java.util.*;

class Solution {
    static final int YEAR = 12;
    static final int MONTH = 28;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] info = term.split(" ");
            termMap.put(info[0], Integer.parseInt(info[1]));
        }
        
        int todays = toDays(today);

        for (int i = 0; i < privacies.length; i++) {
            String[] info = privacies[i].split(" ");
            
            String dates = info[0];
            String term = info[1];
            
            int expire = toDays(dates) + (termMap.get(term) * MONTH);
            
            if (todays >= expire) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }



    private static int toDays(String time) {
        
        String[] t = time.split("\\.");
        int year = Integer.parseInt(t[0]);
        int month = Integer.parseInt(t[1]);
        int day = Integer.parseInt(t[2]);
        
        return year * YEAR * MONTH + month * MONTH + day;
    }
}