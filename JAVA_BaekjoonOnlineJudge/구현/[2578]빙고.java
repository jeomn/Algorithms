import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int bingoCnt;
	static int[][] board;
	static boolean[][] bingo;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[5][5];
		for(int r=0; r<5; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<5; c++) {
				board[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		bingo = new boolean[5][5];
		int idx = 0;
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				int num = Integer.parseInt(st.nextToken());
				findNum(num);
				idx++;
				checkBingo();
				if(bingoCnt >= 3) {
					System.out.println(idx);
					return;
				}
			}
		}
	}


	private static void findNum(int num) {
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				if(board[r][c] == num) {
					bingo[r][c] = true;
					return;
				}
			}
		}
	}	
	
	private static void checkBingo() {
		
		bingoCnt = 0;
		for(int r=0; r<5; r++) {
			int rcnt = 0;
			for(int c=0; c<5; c++) {
				if(bingo[r][c]) rcnt++;
			}
			if(rcnt == 5) bingoCnt++;
		}
		
		for(int c=0; c<5; c++) {
			int ccnt = 0;
			for(int r=0; r<5; r++) {
				if(bingo[r][c]) ccnt++; 
			}
			if(ccnt == 5) bingoCnt++;
		}
		
		int cnt = 0;
		for(int r=0; r<5; r++) {
			if(bingo[r][r]) cnt++;
		}
		if(cnt == 5) bingoCnt++;
		
		cnt = 0;
		for(int r=0; r<5; r++) {
			if(bingo[r][4-r]) cnt++;
		}
		if(cnt == 5) bingoCnt++;
	}
}
