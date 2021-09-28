import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] sequenceA = br.readLine().toCharArray();
		char[] sequenceB = br.readLine().toCharArray();
		
		int lengthA = sequenceA.length;
		int lengthB = sequenceB.length;
		
		int[][] dp = new int[lengthA+1][lengthB+1];
		
		for(int i=1; i<lengthA+1; i++) {
			for(int j=1; j<lengthB+1; j++) {
				if(sequenceA[i-1] == sequenceB[j-1])
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[lengthA][lengthB]);
	}
}
