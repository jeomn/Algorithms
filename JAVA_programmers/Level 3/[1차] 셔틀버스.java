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


//20220302
import java.util.*;

class Solution {
    
    PriorityQueue<Integer> crewTable;
    
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        crewTable = new PriorityQueue<>();
        for(String time : timetable){
            String[] timeSplit = time.split(":");
            int crew = Integer.parseInt(timeSplit[0])*60+Integer.parseInt(timeSplit[1]);
            crewTable.add(crew);
        }
        
        int shuttleStart = 540;
        int shuttleLast = shuttleStart+((n-1)*t);
        int konTime = -1;
        for(int shuttle = shuttleStart; shuttle<=shuttleLast; shuttle+=t){
            int limit = m;
            int lastCrew = -1;
            while(limit>0 && !crewTable.isEmpty() && crewTable.peek() <= shuttle){
                int crew = crewTable.poll();
                --limit;
                if(lastCrew < crew) lastCrew = crew;
            }

            if(limit > 0) konTime = shuttle;
            else konTime = lastCrew-1;
        }
        
        if(konTime == -1) konTime = 0;
        
        String konHour = String.valueOf(konTime/60);
        if(konHour.length() == 1) konHour = "0"+konHour;
        String konMinutes = String.valueOf(konTime%60);
        if(konMinutes.length() == 1) konMinutes = "0"+konMinutes;
        answer = konHour + ":" + konMinutes;
        return answer;
    }
}
