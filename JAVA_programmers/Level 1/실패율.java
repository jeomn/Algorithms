//20210910
//2021 KAKAO BLIND RECRUITMENT

import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public int[] solution(int N, int[] stages) {
        int playerCnt = stages.length;
        double[] clear = new double[N];
        for(int i=0; i<playerCnt; i++){
            int cnt = stages[i];
            if(cnt > N) continue;
            clear[cnt-1]++;
        }
        
        ArrayList<Double> failStage = new ArrayList<>();
        for(int i=0; i<N; i++){
            int challengers = (int)clear[i];
            if(playerCnt == 0){
                clear[i] = 0;
            } else{
                clear[i]/=playerCnt;
            }
            playerCnt -= challengers;
            failStage.add(clear[i]);
        }
        Collections.sort(failStage, Collections.reverseOrder());
        
        int[] answer = new int[N];
        for(int i=0; i<N; i++){
            double failRate = failStage.get(i);
            for(int j=0; j<N; j++){
                if(clear[j] == failRate){
                    answer[i] = j+1;
                    clear[j] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}




//20211223
import java.util.*;

class Fail implements Comparable<Fail>{
    int stage;
    double failRate;
    Fail(int stage, double failRate){
        this.stage = stage;
        this.failRate = failRate;
    }
    
    public int compareTo(Fail o){
        int x = Double.compare(o.failRate, this.failRate);
        if(x==0){
            return this.stage - o.stage;
        }
        return x;
    }
}

class Solution {
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] players = new int[N+1];
        int[] clearPlayers = new int[N+1];
        for(int s : stages){
            players[s-1]++;
            for(int i=0; i<s; i++){
              clearPlayers[i]++;
            }
        }
        
        PriorityQueue<Fail> order = new PriorityQueue<Fail>();
        for(int i=0; i<N; i++){
            if(clearPlayers[i] == 0){
                order.add(new Fail(i+1, 0));
                continue;
            }
            order.add(new Fail(i+1, players[i]/(double)clearPlayers[i]));
        }
        
        for(int i=0; i<N; i++){
            answer[i] = order.poll().stage;
        }
        return answer;
    }
}
