import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_1759_MakingPassword {
	
	static int L, C;
	static char[] alphabet;
	static char[] comb;
	static boolean[] isVowel;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		alphabet = new char[C];
		for(int i=0; i<C; i++) {
			alphabet[i] = st.nextToken().toCharArray()[0];
		}
		Arrays.sort(alphabet);
		
		isVowel = new boolean[C];
		for(int i=0; i<C; i++) {
			char temp = alphabet[i];
			if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u') {
				isVowel[i] = true;
			}
		}
		comb = new char[L];
		makePassword(0, 0, 0, 0);		
	}


	private static void makePassword(int cnt, int idx, int v, int c) {
		if(cnt == L) {
			if(v < 1 || c < 2) return;
			for(int i=0; i<L; i++) {
				System.out.print(comb[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i=idx; i<C; i++) {
			comb[cnt] = alphabet[i];
			if(isVowel[i])
				makePassword(cnt+1, i+1, v+1, c);
			else
				makePassword(cnt+1, i+1, v, c+1);
		}
	}
}
