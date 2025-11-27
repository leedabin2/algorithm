import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 5;
        int len = 0;
        char[][] board = new char[5][15];
        for (int i =0; i < n; i++) {
            String s= br.readLine();
            len = Math.max(len, s.length());
            
            for (int j = 0; j < s.length(); j++) {
                board[i][j] = s.charAt(j);
            }
        }
        
        StringBuilder sb = new StringBuilder();      
        for (int j = 0; j < len; j++) {
            
            for (int i = 0; i < n; i++) {
                if (board[i][j] != '\0') {

                  sb.append(board[i][j]);
                }
    
            }
        }

        System.out.println(sb.toString());
      
    }
}