// 5 :00
import java.util.*;
import java.io.*;

class Main {
    static int N, K, L;
    static Deque<int[]> snake;
    static int[][] board;
    static Map<Integer, Character> info;
    static int[] dx;
    static int[] dy;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      K = Integer.parseInt(br.readLine());

      board = new int[N][N];

      for (int i =0 ; i < K; i++) {
        String[] st = br.readLine().split(" ");
        
        int a = Integer.parseInt(st[0]);
        int b = Integer.parseInt(st[1]);
        
        board[a-1][b-1] = 2;
      }

      L = Integer.parseInt(br.readLine());
      info = new HashMap<>();
      for (int i = 0; i < L; i++) {
        String[] turn = br.readLine().split(" ");
        int time = Integer.parseInt(turn[0]);
        char c = turn[1].charAt(0);
        info.put(time,c);
      }

      dx = new int[]{-1,0,1,0};
      dy = new int[]{0,1,0,-1};
      int dir = 1;

      snake = new ArrayDeque<>();
      snake.add(new int[]{0,0});
      board[0][0] = 1;

      int time = 0;

      while (true) {
        time++;
        // 1. 뱀 머리 위치 계산 [머리, 꼬리]
        int[] head = snake.peekFirst();
        int nx = head[0] + dx[dir];
        int ny = head[1] + dy[dir];
        // 2. 범위 및 자기 몸 충돌 체크

        if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == 1) {
          break; // 게임 종료
        }
        // 3.이동
      
          if (board[nx][ny] == 2) {
            // 사과 : 꼬리 유지
            board[nx][ny] = 1;
            snake.addFirst(new int[]{nx,ny});
          }
          else {
            board[nx][ny] = 1;
            snake.addFirst(new int[]{nx,ny});
            int[] tail = snake.pollLast();
            board[tail[0]][tail[1]] = 0;
          }

           // 4. 방향전환
          if (info.containsKey(time)) {
            char c = info.get(time);
            if ( c == 'L') {
              dir = (dir +3) % 4;
            } else {
              dir = (dir + 1) % 4;
            }
          }

        } 
    
      
      System.out.println(time);
    }
}
