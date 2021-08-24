import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution
{
	static int[][] field;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			field = new int[N][N];
			
			for(int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for(int c=0; c<N; c++) {
					field[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			for(int r=0; r<=N-M; r++) {
				int rangeR = r+M; 
				for(int c=0; c<=N-M; c++) {
					int flyKill = 0;
					int rangeC = c+M;
					
					for(int subR=r; subR<rangeR; subR++) {
						for(int subC=c; subC<rangeC; subC++) {
							flyKill += field[subR][subC];
						}
					}
					max = Math.max(max,  flyKill);					
				}
			}
			System.out.println("#"+t+" "+max);

		}
	}
}
