import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = -1;
        String[] note =  parseMelody(m);

        for (String music : musicinfos) {
            String[] splitInfo = music.split(",");
            String start = splitInfo[0];
            String end = splitInfo[1];
            String name = splitInfo[2];
            String melody = splitInfo[3];
            int playTime = time(start,end);
            String[] melodyNotes = parseMelody(melody);
         
            List<String> playedNotes = new ArrayList<>();
            for (int i = 0; i < playTime; i++) {
                playedNotes.add(melodyNotes[i % melodyNotes.length]);
            }

            if (containsMelody(playedNotes, note)) {
                if (playTime > maxPlayTime) {
                    maxPlayTime = playTime;
                    answer = name;
                }
            }
             
        }
        return answer;
    }
    private String[] parseMelody(String melody) {
        List<String> notes = new ArrayList<>();
        for (int i = 0; i < melody.length(); i++) {
            if (i + 1 < melody.length() && melody.charAt(i + 1) == '#') {
                notes.add(melody.substring(i, i + 2));
                i++; 
            } else {
                notes.add(melody.substring(i, i + 1));
            }
        }
        return notes.toArray(new String[0]);
    }
    
    private boolean containsMelody(List<String> playedNotes, String[] note) {
        for (int i = 0; i <= playedNotes.size() - note.length; i++) {
            boolean found = true;
            for (int j = 0; j < note.length; j++) {
                if (!playedNotes.get(i + j).equals(note[j])) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }
        return false;
    }
    private int time(String start, String end) {
        int startH = Integer.parseInt(start.split(":")[0]);
        int startM = Integer.parseInt(start.split(":")[1]);
        int endH = Integer.parseInt(end.split(":")[0]);
        int endM = Integer.parseInt(end.split(":")[1]);
        
        return (endH * 60 + endM) - (startH * 60 + startM);
    }
    
}
