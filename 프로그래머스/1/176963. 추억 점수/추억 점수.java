import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        List<Integer> res = new ArrayList<>();
        
        for (String[] p : photo) {
            int ans = 0;
            for (String i : p) {
                
                 int index = findIndex(name,i);
            
                 if (index != -1) {
                     ans += yearning[index];
                 }
            }
            res.add(ans);
        }

        return res.stream().mapToInt(i->i).toArray();
    }
    
    public int findIndex(String[] name, String i) {
        for (int j = 0; j < name.length; j++) {
                 if (name[j].equals(i)) {
                     return j;
                 }
             }
        return -1;
    }
    
}