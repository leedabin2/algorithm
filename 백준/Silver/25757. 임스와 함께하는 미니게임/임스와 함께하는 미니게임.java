import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        char type = st[1].charAt(0);

        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine()); 
        }

        int people = set.size();
        int need;

        if (type == 'Y') need = 1;
        else if (type == 'F') need = 2;
        else need = 3;

        System.out.println(people / need);
    }
}
