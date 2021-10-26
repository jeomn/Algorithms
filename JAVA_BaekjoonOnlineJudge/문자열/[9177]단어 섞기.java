import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {
	
	static char[] word1, word2, target;
	static int oneLength, twoLength, targetLength;
	static boolean flag;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		HashSet<Character> wordSet = null;
		test: for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			word1 = st.nextToken().toCharArray();
			word2 = st.nextToken().toCharArray();
			oneLength = word1.length;
			twoLength = word2.length;
			
			wordSet = new HashSet<>();
			for(int i=0; i<Math.max(oneLength, twoLength); i++) {
				if(i<oneLength) wordSet.add(word1[i]);
				if(i<twoLength) wordSet.add(word2[i]);
			}
				
			target = st.nextToken().toCharArray();
			targetLength = oneLength+twoLength;
			
			for(int i=0; i<target.length; i++) {
				if(!wordSet.contains(target[i])) {
					sb.append("Data set "+t+": "+"no\n");
					continue test;
				}
			}
			
			flag = false;
			setWord(0, 0, 0);
			
			String result = (flag)? "yes":"no";
			sb.append("Data set "+t+": "+result+"\n");
		}
		System.out.println(sb);
	}

	private static void setWord(int length, int oneIdx, int twoIdx) {
		if(flag) return;
		if(length == targetLength) {
			flag = true;
			return;
		}
		
		char t = target[length];
		if(oneIdx<oneLength && t==word1[oneIdx]) setWord(length+1, oneIdx+1, twoIdx);
		if(twoIdx<twoLength && t==word2[twoIdx]) setWord(length+1, oneIdx, twoIdx+1);
	}
}
