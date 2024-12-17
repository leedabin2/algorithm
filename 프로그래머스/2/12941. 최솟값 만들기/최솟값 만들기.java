import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int n = A.length;
     
        Arrays.sort(A);
        Arrays.sort(B);
        int[] Bd = new int[n];
        for (int i = 0; i < n; i++) {
            Bd[i] = B[n-1-i];
        }
        

        for (int i = 0; i < n ; i++) {
            answer += A[i] * Bd[i];
        }
        
        return answer;
    }
}