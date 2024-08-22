import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        List<List<Integer>> answer = new ArrayList<>();
        PriorityQueue<Integer> minq = new PriorityQueue<>();
        PriorityQueue<Integer> maxq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String operation : operations) {
            String[] part= operation.split(" ");
            String command = part[0];
            int number = Integer.parseInt(part[1]);
            
            if (command.equals("I")) {
                minq.offer(number);
                maxq.offer(number);
            } else if (command.equals("D")) {
                if (number == 1) {
                    if (maxq.isEmpty()) {
                        continue;
                    }
                    int max = maxq.poll();
                    minq.remove(max);
                } else {
                    if(minq.isEmpty()) {
                        continue;
                    }
                    int min = minq.poll();
                    maxq.remove(min);
                }
                
            } 
        }
        
        if (!minq.isEmpty() || !maxq.isEmpty()) {
            answer.add(Arrays.asList(maxq.peek(), minq.peek()));

        }
        answer.add(Arrays.asList(0,0));

        return answer.get(0).stream().mapToInt(i -> i).toArray();
    }
}