import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        Map<String,Integer> setA = new HashMap<>();
        Map<String,Integer> setB = new HashMap<>();
        for (int i = 0; i < str1.length()-1; i++) {
            String num1 = str1.substring(i,i+2);
            
            if (isAlpha(num1)) {
                num1 = num1.toLowerCase();
                setA.put(num1, setA.getOrDefault(num1, 0) + 1);
            }
           
        }
        for (int i = 0; i < str2.length()-1; i++) {
            String num2 = str2.substring(i,i+2);
            
            if (isAlpha(num2)) {
                num2 = num2.toLowerCase();
                setB.put(num2, setB.getOrDefault(num2, 0) + 1);
            }
           
        }

        int intersectionCount = 0;
        int unionCount = 0;


        for (String key : setA.keySet()) {
            if (setB.containsKey(key)) {
                intersectionCount += Math.min(setA.get(key), setB.get(key));
            }
        }
        
        
        Set<String> allKeys = new HashSet<>(setA.keySet());
        allKeys.addAll(setB.keySet()); 
   
        for (String key : allKeys) {
            int countA = setA.getOrDefault(key,0);
            int countB = setB.getOrDefault(key, 0);
            unionCount += Math.max(countA, countB);
        }
        if (unionCount == 0) {
            answer = 65536;
        }
        else {
            double res = (double) intersectionCount / unionCount;
            answer = (int) (res * 65536);
        }

        return answer;
    }
    private boolean isAlpha(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}