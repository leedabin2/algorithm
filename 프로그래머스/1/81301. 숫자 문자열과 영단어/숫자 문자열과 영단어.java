import java.util.*;

class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        
        String st = "";
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                sb.append(ch);
                st = "";
            }
            else {
                st += ch;
                if (map.containsKey(st)) {
                    sb.append(map.get(st));
                    st = "";
                }
            }

        }
        
        return Integer.parseInt(sb.toString());
    }
}