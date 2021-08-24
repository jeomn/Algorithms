import java.io.BufferedReader;
import java.io.InputStreamReader;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			int N = Integer.parseInt(br.readLine());
            
			int center = N/2;
			int crops = 0;
			for(int r=0; r<N; r++) {
				char[] temp = br.readLine().toCharArray();
				int range = (r<=center)? center-1-r:center-(N-r);
				for(int c=0; c<N; c++) {
					if(c<=range || N-1-c<=range)
						continue;
					crops += temp[c]-'0';
				}
			}
			System.out.println("#"+test+" "+crops);
		}
	}
}
