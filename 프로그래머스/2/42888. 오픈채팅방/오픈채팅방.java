import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        // uid1234 : {muzi} , uid4567 {prodo}
        
        Map<String, String> users = new HashMap<>();
        List<String[]> logs = new ArrayList<>();
        
        
        for (String r : record) {
            String[] info = r.split(" ");
            String cmd = info[0];
            String id = info[1];
            
            if (cmd.equals("Enter")) {
                String nick = info[2];
                users.put(id, nick);
                logs.add(new String[]{id, "enter"});
            } else if (cmd.equals("Leave")) {
                logs.add(new String[]{id, "leave"});
            } else {
                String nick = info[2];
                users.put(id, nick);
            }
        }
        
        String[] answer = new String[logs.size()];
        for (int i =0; i < logs.size(); i++) {
            String id = logs.get(i)[0];
            String cmd = logs.get(i)[1];
            String nick = users.get(id);
            
            if ("enter".equals(cmd)) {
                answer[i] = nick + "님이 들어왔습니다.";
            } else {
                answer[i]= nick + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}