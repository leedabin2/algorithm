import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, (file1, file2) -> {
            String[] f1 = split(file1);
            String[] f2 = split(file2);
            
            int headCompare = f1[0].compareToIgnoreCase(f2[0]);
            if (headCompare != 0) {
                return headCompare;
            }
            
            return Integer.compare(Integer.parseInt(f1[1]), Integer.parseInt(f2[1]));
        });
        return files;
    }
    
    private String[] split(String file) {
        String head = "";
        String number = "";
        
        int i = 0;
        while( i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }
     
        while ( i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i);
            i++;
        }
     
        return new String[]{head, number};
    }
}