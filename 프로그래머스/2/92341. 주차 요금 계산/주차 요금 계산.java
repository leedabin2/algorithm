import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
     
        Map<Integer, Integer> total = new HashMap<>(); // 총 주차시간
        Map<Integer, Integer> entry = new HashMap<>();
        // 차량 작은 번호 부터 정렬
        
        for (String r : records) {
            String[] info = r.split(" ");
            int time = toMin(info[0]);
            int car = Integer.parseInt(info[1]);
            String cmd = info[2];
            
            if (cmd.equals("IN")) {
                entry.put(car, time);
            } else {
                int inTime = entry.get(car);
                total.put(car, total.getOrDefault(car, 0) + (time - inTime));
                entry.remove(car);            }
        }
        
        for (int car : entry.keySet()) {
            int inTime = entry.get(car);
            
            total.put(car, total.getOrDefault(car, 0) + (toMin("23:59") - inTime));
        }
        
        List<Integer> cars = new ArrayList<>(total.keySet());
        Collections.sort(cars);
        
        int[] answer = new int[cars.size()];
        int idx = 0;
        
        for (int car : cars) {
            int time = total.get(car);
            
            int fee = 0;
            if (time <= fees[0]) fee = fees[1];
            else fee = fees[1] + (int) Math.ceil((time - fees[0]) / (double) fees[2]) * fees[3];
            
            answer[idx++] = fee;
        }
        
        
        return answer;
    }
    static int toMin(String s) {
        String[] t = s.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}