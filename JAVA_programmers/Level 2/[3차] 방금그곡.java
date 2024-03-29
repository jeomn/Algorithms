import java.util.*;

class  Solution {
	
	static String[] original = {"C#", "D#", "F#", "G#", "A#"};
	static String[] change = {"c", "d", "f", "g", "a"};
	static PriorityQueue<Music> musicList;
	static class Music implements Comparable<Music>{
		int num, time;
		String name, melody;
		Music(int num, int time, String musicName, String melody){
			this.num = num;
			this.time = time;
			this.name = musicName;
			this.melody = melody;
		}
		@Override
		public int compareTo(Music o) {
			int x = o.time-this.time;
			if(x == 0) {
				return this.num-o.num;
			}
			return x;
		}
	}

	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		
		musicList = new PriorityQueue<>();
		for(int i=0; i<musicinfos.length; i++) {
			String[] musicinfo = musicinfos[i].split(",");
			
			int timeD = getTime(musicinfo[0], musicinfo[1]);
			String musicName = musicinfo[2];
			String tempMelody = setSound(musicinfo[3]);
			String melody = "";
			for(int j=0; j<timeD; j++) {
				int idx = j % tempMelody.length();
				melody+=tempMelody.charAt(idx);
			}
			musicList.add(new Music(i, timeD, musicName, melody));
		}
		
		String mSound = setSound(m); 
		for(int i=0; i<musicinfos.length; i++) {
			Music music = musicList.poll();
			if(music.melody.contains(mSound)) {
				return music.name;
			}
		}
        return answer;
	}

	private static String setSound(String originSound) {
		String changeSound = originSound;
		for(int i=0; i<original.length; i++) {
			changeSound = changeSound.replaceAll(original[i], change[i]);
		}
		return changeSound;
	}

	private static int getTime(String start, String end) {
		String[] startTime = start.split(":");
		String[] endTime = end.split(":");
		
		int startHour = Integer.parseInt(startTime[0]);
		int startMinute = Integer.parseInt(startTime[1]);
		int endHour = Integer.parseInt(endTime[0]);
		int endMinute = Integer.parseInt(endTime[1]);
		
		return (endHour-startHour)*60 + (endMinute-startMinute);
	}
}






//20220107
import java.util.*;

class Music implements Comparable<Music>{
    int order, time;
    String name, melody;
    Music(int order, String name, int time, String melody){
        this.order = order;
        this.name = name;
        this.time = time;
        this.melody = melody;
    }
    
    public int compareTo(Music o){
        int x = o.time - this.time;
        if(x==0) return this.order-o.order;
        return x;
    }
}

class  Solution {
    
    HashMap<String, String> soundMap = new HashMap<>(){
        {
            put("C#", "c");
            put("D#", "d");
            put("F#", "f");
            put("G#", "g");
            put("A#", "a");
        }  
    };
    
	public String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		
        m = setSound(m);
        
        int idx = 0;
        PriorityQueue<Music> candidate = new PriorityQueue<Music>();
        for(String musicInfo : musicinfos){
            String[] infos = musicInfo.split(",");
            int time = getTimeDiffer(infos[0], infos[1]);
            
            String melody = "";
            infos[3] = setSound(infos[3]);
            int len = infos[3].length();
            for(int t=0; t<time; t++){
                melody+=infos[3].charAt(t%len);
            }
            if(melody.contains(m)) candidate.add(new Music(idx, infos[2], time, melody));
            idx++;
        }
		
        if(candidate.size() >= 1) answer = candidate.poll().name;
        return answer;
	}
    
    public String setSound(String origin){
        String sound = origin;
        for(String key : soundMap.keySet()){
            sound = sound.replace(key, soundMap.get(key));
        }
        return sound;
    }
    
    public int getTimeDiffer(String startTime, String endTime){
        String[] start = startTime.split(":");
        String[] end = endTime.split(":");
        
        int startHour = Integer.parseInt(start[0]);
        int startMinutes = Integer.parseInt(start[1]);
        int endHour = Integer.parseInt(end[0]);
        int endMinutes = Integer.parseInt(end[1]);
        
        return (endHour-startHour)*60+(endMinutes-startMinutes);
    }
}
