import java.util.*;

class Solution {
    public String[] solution(String[] record) {

        Map<String,String> userMap = new HashMap<>();
        List<String[]> actions = new ArrayList<>(); 
        for (String info : record) {
            String[] chatInfo = info.split(" ");
            String command = chatInfo[0];
            String userId = chatInfo[1];
  
            if (command.equals("Enter")) {
                String nickName = chatInfo[2];
                userMap.put(userId, nickName);
                actions.add(new String[]{command,userId});
            } else if (command.equals("Change")) {
                String nickName = chatInfo[2];
                userMap.put(userId,nickName);
            } else {
                 actions.add(new String[]{command,userId});
            }
             
        }
        
        List<String> result = new ArrayList<>();
        for (String[] action : actions) {
            String command = action[0];
            String userId = action[1];
            String nickName = userMap.get(userId);
            
            if (command.equals("Enter")) {
                result.add(nickName + "님이 들어왔습니다.");
            } else {
                result.add(nickName + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[0]);
    }
}