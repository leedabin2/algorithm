class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int os = toSeconds(op_start);
        int oe = toSeconds(op_end);
        
        for (String cmd : commands) {
            int p = toSeconds(pos);
            
            if (os <= p && p <= oe) {
                pos = op_end;
                p = toSeconds(pos); 
            }

            if (cmd.equals("prev")) {
                // 현재위치가 10초 미만이면 영상의 처음 위치
                if (p < 10) {
                    pos = "00:00";
                } else {
                    pos = toString(p-10); 
                }
            } else if (cmd.equals("next")) {
                // 남은 시간이 10초 미만이면 종료로 위치
                if (toSeconds(video_len) -p < 10) {
                    pos = video_len;
                }else {
                    pos = toString(p+10);
                }

            }
            
            p = toSeconds(pos);
        
            if (os <= p && p <= oe) {
                pos = op_end;
            }
        }
    
        
        return pos;
    }
    static String toString(int time) {
        int m = time / 60;
        int s = time % 60;
        return String.format("%02d:%02d", m, s);
    }
    static int toSeconds(String time) {
        String[] t = time.split(":");
        return (Integer.parseInt(t[0]) * 60) + Integer.parseInt(t[1]);
    }
}