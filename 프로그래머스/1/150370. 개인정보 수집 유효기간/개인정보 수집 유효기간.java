import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String,Integer> term = new HashMap<>();
        for (String t : terms) {
            String[] row = t.split(" ");
            term.put(row[0], Integer.parseInt(row[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            String[] date = privacy[0].split("\\.");
            
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);
            int day =  Integer.parseInt(date[2]);
            String type = privacy[1];
            
            int typeMonth = term.get(type);
            
            boolean expire = checkExprire(today, year,month,day,typeMonth);
            
            if (expire) {
                answer.add(i+1);
            }
            
            
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
    private boolean checkExprire(String today, int year, int month, int day, int typeMonth) {
        String[] todays = today.split("\\.");
        
        int todayYear = Integer.parseInt(todays[0]);
        int todayMonth = Integer.parseInt(todays[1]);
        int todayDay = Integer.parseInt(todays[2]);
        
        int todayTotal = todayYear * 12 * 28 + todayMonth * 28 + todayDay;
        int startTotal = year * 12 * 28 + month * 28 + day;

        
        int expireDate = startTotal + (typeMonth * 28);
        if (expireDate <= todayTotal) {
            return true;
        }
        
        return false;
        
    }
}