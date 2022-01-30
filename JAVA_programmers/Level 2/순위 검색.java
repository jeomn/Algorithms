import java.util.*;


class Solution {
  
  static String[] infoList;
	static HashMap<String, ArrayList<Integer>> queryMap = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
		
        for(String infoTemp: info){
        	infoList = infoTemp.split(" ");
        	makeQuery(0, "");
        }
        
        for(String q: queryMap.keySet()) {
            Collections.sort(queryMap.get(q));
        }
        
        for(int i=0; i<query.length; i++) {
        	String q = query[i].replace(" and ", " ");
        	String[] qTemp = q.split(" ");
        	int qScore = Integer.parseInt(qTemp[4]);
        	String queryTemp = String.join("", qTemp[0], qTemp[1], qTemp[2], qTemp[3]);
        	
        	ArrayList<Integer> valueList = queryMap.getOrDefault(queryTemp, null);
        	if(valueList == null) {
        		answer[i] = 0;
        	}else {
        		int count = findLowerBound(valueList, qScore, valueList.size());
        		answer[i] = count;
        	}
        }
        
        return answer;
    }
        
	public void makeQuery(int cnt, String q) {
		if(cnt == 4) {
			if(!queryMap.containsKey(q)) queryMap.put(q, new ArrayList<>());
			queryMap.get(q).add(Integer.parseInt(infoList[4]));
			return;
		}
		
		makeQuery(cnt+1, q+"-");
		makeQuery(cnt+1, q+infoList[cnt]);
	}
	
	public static int findLowerBound(ArrayList<Integer> valueList, int score, int size) {
		int start = 0, end = size-1;
		int mid = 0;
		
		while(start<=end) {
			mid = (start+end)/2;
			if(valueList.get(mid) < score) start = mid+1;
			else end=mid-1;
		}
		
		return size-start;
	}
}




//20220130
import java.util.*;


class Solution {
    
    String[] content, tempQuery;
    HashMap<String, ArrayList<Integer>> count = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
		
        for(String i : info){
            content = i.split(" ");
            tempQuery = new String[4];
            makeQuery(0);
        }
        
        for(String key : count.keySet()){
            Collections.sort(count.get(key));
        }
        
        for(int idx=0; idx<query.length; idx++){
            String q = query[idx];
            q = q.replace(" and ", " ");
            String[] queryContent = q.split(" ");
            
            String key = String.join(queryContent[0], queryContent[1], queryContent[2], queryContent[3]);
            int score = Integer.parseInt(queryContent[4]);
            
            ArrayList<Integer> scoreList = count.getOrDefault(key, null);
            if(scoreList == null) answer[idx] = 0;
            else answer[idx] = lowerBound(scoreList, score, scoreList.size());
        }
        
        return answer;
    }
    
    public void makeQuery(int cnt){
        if(cnt==4){
            String key = String.join(tempQuery[0], tempQuery[1], tempQuery[2], tempQuery[3]);
            if(!count.containsKey(key)) count.put(key, new ArrayList<Integer>());
            count.get(key).add(Integer.parseInt(content[4]));
            return;
        }
        
        tempQuery[cnt] = content[cnt];
        makeQuery(cnt+1);
        tempQuery[cnt] = "-";
        makeQuery(cnt+1);
    }
    
    public int lowerBound(ArrayList<Integer> list, int goal, int size){
        int start = 0, end = size-1, mid = 0;
        
        while(start <= end){
            mid = (start+end)/2;
            if(list.get(mid) < goal) start = mid+1;
            else end = mid-1;
        }
        
        return size-start;
    }
}
