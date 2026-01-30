import java.util.*;

class Solution {
    static Set<Character> set = Set.of('-', '_','.');
    public String solution(String new_id) {
        
        // 1단계
        String id = new_id.toLowerCase();
        // 2단계
        id = twoStep(id);
        // 3단계
        id = treeStep(id);
        // 4단계
        id = fourStep(id);
        // 5단계
        if (id.isEmpty()) id += "a";
        // 6단계
        if (id.length() >= 16) id = sixStep(id);
        // 7단계
        if (id.length() <= 2) {
            char lastChar = id.charAt(id.length()-1);
            
            while(id.length() < 3) {
                id += lastChar;
            }
        }
        return id;
    }
    static String sixStep(String id) {
        id = id.substring(0, 15);
        int end = id.length();
        while(end > 0 && id.charAt(end-1) == '.') {
            end--;
        }
       
        return id.substring(0, end);
        
    }
    static String fourStep(String id) {
        int end = id.length();
        int start = 0;
        if (id.charAt(id.length()-1) == '.') end--;
        if (id.charAt(0) == '.') start++;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(id.charAt(i));
        }
        return sb.toString();
        
    }
    static String treeStep(String id) {
        StringBuilder sb = new StringBuilder();
        boolean prevdot = false;
        
        for (char ch : id.toCharArray()) {
            if (ch == '.') {
                if (!prevdot) {
                    sb.append(ch);
                    prevdot = true;
                }
            } else {
                sb.append(ch);
                prevdot = false;
            }
        }
        return sb.toString();
    }
    static String twoStep(String id) {
        StringBuilder sb = new StringBuilder();
        for (char ch : id.toCharArray()) {
            if (Character.isDigit(ch)
            || Character.isLowerCase(ch)
            || set.contains(ch)) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}