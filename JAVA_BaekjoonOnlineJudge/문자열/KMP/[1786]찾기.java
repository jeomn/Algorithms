import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1786_Find {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String T = br.readLine();
		String P = br.readLine();

		int tlen = T.length();
		int plen = P.length();
		int[] pi = new int[plen];
		for(int i=1, j=0; i<plen; i++) {
			while(P.charAt(i) != P.charAt(j) && j>0) {
				j = pi[j-1];
			}
			
			if(P.charAt(i) == P.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0, j=0; i<tlen; i++) {
			while(T.charAt(i) != P.charAt(j) && j>0) {
				j = pi[j-1];
			}
			
			if(T.charAt(i) == P.charAt(j)) {
				if(j == plen-1) {
					cnt++;
					list.add(i-j+1);
					j = pi[j];
				}else {
					j++;
				}
			}
		}
		System.out.println(cnt);
		for(int i=0; i<cnt; i++) {
			System.out.println(list.get(i));
		}

	}

}
