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
