import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> mail = new HashMap<>();
        for (String id : id_list) {
            map.put(id, new HashSet<>());
            mail.put(id, 0);
        }
        
        for (String rep : report) {
            String[] st = rep.split(" ");
            String from = st[0];
            String to = st[1];
            map.get(to).add(from); 
        }
        
        // 정지된 유저 판별 후 메일 카운트
        for (String target : map.keySet()) {
            Set<String> reporters = map.get(target);
            if (reporters.size() >= k) {
                for (String reporter : reporters) {
                    mail.put(reporter, mail.get(reporter) + 1);
                }
            }
        }
        
        int[] res = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            res[i] = mail.get(id_list[i]);
        }
        
        
        
        return res;
    }
}