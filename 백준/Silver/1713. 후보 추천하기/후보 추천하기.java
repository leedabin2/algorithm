import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    String[] st = br.readLine().split(" ");

    int[] recommendCnt = new int[101]; // 추천 수
    int[] time = new int[101];         // 사진틀에 들어온 시간

    List<Integer> photo = new ArrayList<>();

    for (int i = 0; i < M; i++) {
      int student = Integer.parseInt(st[i]);

      // 이미 사진 틀에 잇는경우 
      if (photo.contains(student)) {
        recommendCnt[student]++;
      } else {
        // 자리가 없는 경우
        if (photo.size() == N) {
          int remove = photo.get(0);

          for (int j = 1; j < photo.size(); j++) {
            int s = photo.get(j);
            if (recommendCnt[s] < recommendCnt[remove]) {
              remove = s;
            } else if (recommendCnt[s] == recommendCnt[remove]) {
              if (time[s] < time[remove]) {
                // 추천 수가 같은 학생이 많으면 오래된 사진이면 제거
                remove = s;
              }
            }
          }

          for (int j = 0; j < photo.size(); j++) {
            if (photo.get(j) == remove) {
              photo.remove(j);
            }
          }

          // photo.remove(Integer.valueOf(remove));
          recommendCnt[remove] = 0;

          photo.add(student);
          time[student] = i;
          recommendCnt[student] = 1;
        } else {
          // 자리가 있는 경우 
          photo.add(student);
          time[student] = i;
          recommendCnt[student] = 1;
        }
      }

    }

    Collections.sort(photo);

    for (int num : photo) {
      System.out.print(num + " ");
    }
   }
}