import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 신고당한유저 : 신고한유저
        Set<String> relations = new HashSet<>();
        for (String r : report) {
            relations.add(r); // "신고자 신고당한자"
        }
        // 신고당한 유저 : 횟수
        Map<String, Integer> reportUsers = new HashMap<>();
        // 유저 : 메일횟수
        Map<String, Integer> userMail = new HashMap<>();
        for (String id : id_list) {
            userMail.put(id, 0);
        }

        for (String r : relations) {
            String[] info = r.split(" ");
            String reported = info[1];
            reportUsers.put(reported, reportUsers.getOrDefault(reported, 0) + 1);
        }
        
        for (String r : relations) {
            String[] info = r.split(" ");
            String reporter = info[0];
            String reported = info[1];
            if (reportUsers.get(reported) >= k) {
                userMail.put(reporter, userMail.getOrDefault(reporter, 0) + 1);
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = userMail.get(id_list[i]);
        }
        
        return answer;
    }
}