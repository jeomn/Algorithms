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
