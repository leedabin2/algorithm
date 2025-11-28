import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        int time = 0;
        
        for (char ch : s.toCharArray()) {
            
            if (ch <= 'C') time += 3;
            else if (ch <= 'F') time += 4;
            else if (ch <= 'I') time += 5;
            else if (ch <= 'L') time += 6;
            else if (ch <= 'O') time += 7;
            else if (ch <= 'S') time += 8;
            else if (ch <= 'V') time += 9;
            else time += 10;
        }
        
        System.out.println(time);
    }
}
