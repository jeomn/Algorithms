import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		
		board = new int[3];
		int[][] maxGameScore = new int[2][3];
		int[][] minGameScore = new int[2][3];
		int min = -1, max = -1, idx=0, nIdx = 1;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<3; c++) {
				board[c] = Integer.parseInt(st.nextToken());
			}
			if(r==0) {
				System.arraycopy(board, 0, maxGameScore[0], 0, 3);
				System.arraycopy(board, 0, minGameScore[0], 0, 3);
				continue;
			}
			
			if(idx==0) {
				idx = 1;
				nIdx = 0;
			}else {
				idx = 0;
				nIdx = 1;
			}
			for(int c=0; c<3; c++) {
				if(c==0) {
					max = Math.max(maxGameScore[nIdx][c], maxGameScore[nIdx][c+1]);
					maxGameScore[idx][c] = board[c]+max;
					
					min = Math.min(minGameScore[nIdx][c], minGameScore[nIdx][c+1]);
					minGameScore[idx][c] = board[c]+min;
					
					continue;
				}else if(c==2) {
					max = Math.max(maxGameScore[nIdx][c-1], maxGameScore[nIdx][c]);
					maxGameScore[idx][c] = board[c]+max;
					
					min = Math.min(minGameScore[nIdx][c-1], minGameScore[nIdx][c]);
					minGameScore[idx][c] = board[c]+min;
					
					continue;
				}
				
				max = Math.max(maxGameScore[nIdx][c-1], Math.max(maxGameScore[nIdx][c], maxGameScore[nIdx][c+1]));
				maxGameScore[idx][c] = board[c]+max;
				
				min = Math.min(minGameScore[nIdx][c-1], Math.min(minGameScore[nIdx][c], minGameScore[nIdx][c+1]));
				minGameScore[idx][c] = board[c]+min;
			}
		}
		
		int maxScore = Arrays.stream(maxGameScore[idx]).max().getAsInt();
		int minScore = Arrays.stream(minGameScore[idx]).min().getAsInt();
		
		System.out.println(maxScore+" "+minScore);
	}
}
