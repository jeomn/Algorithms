import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sequenceFirst = br.readLine();
		String sequenceSecond = br.readLine();
		
		int lenFirst = sequenceFirst.length();
		int lenSecond = sequenceSecond.length();
		
		String[][] lcs = new String[lenFirst+1][lenSecond+1];
		lcs[0][0] = "";
		
		int len1 = 0, len2 = 0;
		for(int i=1; i<lenFirst+1; i++) {
			char c1 = sequenceFirst.charAt(i-1);
			for(int j=1; j<lenSecond+1; j++) {
				if(i==1) lcs[0][j] = "";
				if(j==1) lcs[i][0] = "";
				lcs[i][j] = "";
				
				
				char c2 = sequenceSecond.charAt(j-1);
				if(c1 == c2) {
					lcs[i][j] = lcs[i-1][j-1]+String.valueOf(c1);
				}else {
					len1 = lcs[i-1][j].length();
					len2 = lcs[i][j-1].length();
					if(len1 >= len2) {
						lcs[i][j] = lcs[i-1][j];
					}else {
						lcs[i][j] = lcs[i][j-1];
					}
				}
			}
		}
		
		String maxString = lcs[lenFirst][lenSecond];
		int maxLength = lcs[lenFirst][lenSecond].length();
		System.out.println(maxLength);
		if(maxLength!=0) System.out.println(maxString);
	}
}
