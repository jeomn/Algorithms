import java.util.*;

class Solution {
    
    static class Truck{
        int t, w;
        Truck(int t, int w){
            this.t = t;
            this.w = w;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckNum = truck_weights.length;
        
        Queue<Truck> bridge = new LinkedList<>();
        int totalW = 0, tNum = 0, passNum = 0;
        while(passNum != truckNum){
            answer++;
            
            if(!bridge.isEmpty() && answer-bridge.peek().t == bridge_length){
                totalW -= bridge.poll().w;
                passNum++;
            }
            
            if(tNum < truckNum && truck_weights[tNum]+totalW <= weight){
                bridge.offer(new Truck(answer, truck_weights[tNum]));
                totalW += truck_weights[tNum];
                tNum++;
            }
        }
        
        return answer;
    }
}
