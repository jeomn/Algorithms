import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, ArrayList<String>> cMap = new HashMap<>();
        for(String[] c: clothes){
            if(!cMap.containsKey(c[1])) cMap.put(c[1], new ArrayList<>());
            cMap.get(c[1]).add(c[0]);
        }
        
        for(Map.Entry<String, ArrayList<String>> e:cMap.entrySet()){
            answer *= (e.getValue().size()+1);
        }
        return answer-1;
    }
}
