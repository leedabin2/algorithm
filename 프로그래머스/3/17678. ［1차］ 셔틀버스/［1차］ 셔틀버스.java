import java.util.*;
class Solution {
    static int startBus = 9 * 60; // 9:00
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        int N = timetable.length;
        
    
        // timetable을 분 단위로 정렬
        int[] table = new int[N];
        
        for (int i =0; i < timetable.length; i++) {
            table[i] = sortTimetable(timetable[i]);   
        }
        
        Arrays.sort(table);
        
        int[] bus = new int[n];
        // 셔틀 운행 시각을 리스트로 만들고
        for (int i = 0; i < n; i++) {
            bus[i] = startBus + i * t;
        }
        
        int crewIdx = 0;     // 크루 포인터
        int lastCrew = 0;    // 마지막에 탄 사람 시간
        int crewCount = 0;   // 현재 버스에 탄 인원

        // 3. 각 셔틀마다 크루 태우기
        for (int i = 0; i < n; i++) {
            crewCount = 0;

            while (crewIdx < table.length && table[crewIdx] <= bus[i] && crewCount < m) {
                lastCrew = table[crewIdx];
                crewIdx++;
                crewCount++;
            }
        }
        // 4. 마지막 셔틀 기준으로 answer 결정
        int conTime;
        if (crewCount < m) {
            conTime = bus[n - 1]; // 자리가 남았으면 그냥 셔틀 시간에 도착
        } else {
            conTime = lastCrew - 1; // 마지막 사람보다 1분 일찍
        }

        return toTime(conTime);
        

    }
    static int sortTimetable(String t) {
        String[] time = t.split(":");
        int hour = Integer.parseInt(time[0]) * 60;
        int min = Integer.parseInt(time[1]); 
        return hour + min;
    
    }
    static String toTime(int conTime) {
        int h = conTime / 60;
        int m = conTime % 60;
        return String.format("%02d:%02d", h, m);
    }
}