import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
      
	    List<String> sortedPhone_book = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(sortedPhone_book);
        
        for (int i = 1; i < sortedPhone_book.size(); i++) {
            if(sortedPhone_book.get(i).startsWith(sortedPhone_book.get(i-1))){
                return false;
            }
            
        }
        
        return true;
    }
}