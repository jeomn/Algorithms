//2018 KAKAO BLIND RECRUITMENT
//20211027

import java.util.*;

class Solution {
    
    static Integer[] timetableInt;
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        timetableInt = new Integer[timetable.length];
        for(int i=0; i<timetable.length; i++){
            String time = timetable[i];
            setTime(i, time);
        }        
        
        Arrays.sort(timetableInt);
        Deque<Integer> crew = new LinkedList<>();
        crew.addAll(Arrays.asList(timetableInt));
        int shuttle = 900;
        int count = 0, idx=0, lastTime = 1;
        for(int i=0; i<n; i++){
            count = 0;
            while(!crew.isEmpty() && crew.peek()<=shuttle && count < m){
                lastTime = crew.poll();
                count++;
            }
            
            if(i==n-1){
                if(count<m) lastTime = shuttle;
                else lastTime -= 1;
            }

            shuttle+=t;
            if(shuttle%100 >= 60) shuttle = ((shuttle/100)+1)*100 + ((shuttle%100)-60);
        }
        
        if(lastTime%100 == 99) lastTime = ((lastTime/100))*100 + 59;
        answer = makeTime(lastTime);
        
        return answer;
    }
    
    public void setTime(int idx, String time){
        String[] tempTime = time.split(":");
        timetableInt[idx] = Integer.parseInt(tempTime[0])*100 + Integer.parseInt(tempTime[1]);
    }
    
    public String makeTime(int time){
        StringBuilder sb = new StringBuilder();
        String temp = Integer.toString(time);
        sb.append(temp);
        for(int i=0; i<4-temp.length(); i++) sb.insert(0, "0");
        sb.insert(2, ":");
        return sb.toString();        
    }
}
