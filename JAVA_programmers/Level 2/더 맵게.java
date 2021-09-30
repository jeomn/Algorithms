import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> fQueue = new PriorityQueue<>();
        for(int s : scoville){
            fQueue.offer(s);
        }
        
        while(true){
            int a = fQueue.poll();
            if(a >= K) break;
            if(fQueue.isEmpty()){
                answer = -1;
                break;
            }
            int b = fQueue.poll();
            
            int newFood = a+(2*b);
            fQueue.offer(newFood);
            answer++;
        }
        
        return answer;
    }
}
