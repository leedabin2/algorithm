import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        // 현재날짜로부터 (28*12)+17을 계산 후 6달보다 높으면 result +
        HashMap<String,Integer> hashTerms = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] a = terms[i].split(" ");
            hashTerms.put(a[0],Integer.parseInt(a[1]));
        }
      
        String[] todaysParse = today.split("\\.");
        int year = Integer.parseInt(todaysParse[0]);
        int month = Integer.parseInt(todaysParse[1]);
        int day = Integer.parseInt(todaysParse[2]);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] parsePrivacies = privacies[i].split(" ");
            String pTerm = parsePrivacies[1];
            int pYear =  Integer.parseInt(parsePrivacies[0].split("\\.")[0]);
            int pMonth =  Integer.parseInt(parsePrivacies[0].split("\\.")[1]);
            int pDay =  Integer.parseInt(parsePrivacies[0].split("\\.")[2]);
            
            int total = ((year-pYear)*12*28 + (month-pMonth)*28 + (day-pDay));
            if(total >= hashTerms.get(pTerm) * 28) {
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}