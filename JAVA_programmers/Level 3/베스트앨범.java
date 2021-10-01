import java.util.*;

class Solution {
    
    static class Music implements Comparable<Music>{
        int n, play;
        Music(int n, int play){
            this.n = n;
            this.play = play;
        }
		@Override
		public int compareTo(Music o) {
			int x = o.play - this.play;
			if(x == 0) {
				return this.n - o.n;
			}
			return x;
		}
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCnt = new HashMap<>();
        Map<String, PriorityQueue<Music>> musicMap = new HashMap<>();
        for(int i=0; i<plays.length; i++){
        	if(!musicMap.containsKey(genres[i])) musicMap.put(genres[i], new PriorityQueue<Music>());
        	musicMap.get(genres[i]).add(new Music(i, plays[i]));
            genreCnt.put(genres[i], genreCnt.getOrDefault(genres[i], 0)+plays[i]);
        }
        
        List<Map.Entry<String, Integer>> sortList = new LinkedList<>(genreCnt.entrySet());
        sortList.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));
        ArrayList<Integer> tempAnswer = new ArrayList<>();
        for(Map.Entry<String, Integer> e:sortList) {
        	String genre = e.getKey();
        	int cnt = 0;
        	while(!musicMap.get(genre).isEmpty()) {
        		if(cnt == 2) break;
        		tempAnswer.add(musicMap.get(genre).poll().n);
        		cnt++;
        	}
        }
        
        int[] answer = new int[tempAnswer.size()];
        int idx = 0;
        for(int value:tempAnswer) {
        	answer[idx++] = value;
        }
        
        return answer;
    }
}
