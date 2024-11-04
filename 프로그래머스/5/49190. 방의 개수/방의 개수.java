import java.util.*;
class Solution {
    public int solution(int[] arrows) {
        int answer = 0;
     
        int[][] dist = {
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1},
            {-1,-1},
            {-1,0},
            {-1,1}
        };

        Set<String> visitedEdges = new HashSet<>();
        Set<String> visitedPoints = new HashSet<>();
        
        int x = 0;
        int y = 0;
        int roomCount = 0;
        
        visitedPoints.add(x + "," + y); 
      
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                int nx = x + dist[arrow][0];
                int ny = y + dist[arrow][1];

     
                String edge = x + "," + y + "-" + nx + "," + ny;
                String reverseEdge = nx + "," + ny + "-" + x + "," + y;

            
                if (visitedPoints.contains(nx + "," + ny)) {
                    if (!visitedEdges.contains(edge)) {
                        roomCount++; 
                    }
                } else {
            
                    visitedPoints.add(nx + "," + ny);
                }

   
                visitedEdges.add(edge);
                visitedEdges.add(reverseEdge);

                x = nx;
                y = ny;
            }
        }
        
        return roomCount;
    }
}