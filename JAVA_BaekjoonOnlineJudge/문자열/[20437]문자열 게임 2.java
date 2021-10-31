import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	static String W;
	static int K, Wlength, minLength, maxLength;
	static int[] alphabet;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			W = br.readLine();
			K = Integer.parseInt(br.readLine());
			
			Wlength = W.length();
			alphabet = new int[26];
			for(int i=0; i<Wlength; i++) {
				alphabet[W.charAt(i)-'a']++;
			}
			
			minLength = Integer.MAX_VALUE;
			maxLength = -1;
			findWord();
			if(minLength==Integer.MAX_VALUE) System.out.println("-1");
			else System.out.println(minLength+" "+maxLength);
		}
	}

	private static void findWord() {
		for(int i=0; i<Wlength; i++) {
			char c = W.charAt(i);
			if(alphabet[c-'a'] < K) continue;
			
			int cnt=0, j=0;
			for(j=i; j<Wlength; j++) { //cnt=1 / j=i+1로 하면 5%에서 계속 틀렸음 >> j의 문제. K==1일때, j 시작이 이미 i+1이 되서 최소/최대 연속 문자열이 1이 아닌 2가 됨.
				if(W.charAt(j)==c) cnt++;
				if(cnt==K) {
					int length = j-i+1;
					minLength = Math.min(minLength, length);
					maxLength = Math.max(maxLength, length);
					break;
				}
			}
		}
	}
}
