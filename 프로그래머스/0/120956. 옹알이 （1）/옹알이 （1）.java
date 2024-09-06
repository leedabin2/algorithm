class Solution {
    public int solution(String[] babbling) {
        
        int answer = 0;
        String[] validWords = {"aya", "ye", "woo", "ma"};
        
        for (String b : babbling) {
           String previous = "";
         while (b.length() > 0) {
                
                boolean isValid = false;
             for (String word : validWords) {
                if (b.startsWith(word) && !word.equals(previous)) {
                    b = b.substring(word.length()); 
                    previous = word;
                    isValid = true;
                    break;
                }
             }
             
             if(!isValid) {
                 break;
             }


            }
            
            if (b.length() == 0) {
                answer++;
            }

        }
    
        
        return answer;
    }
}