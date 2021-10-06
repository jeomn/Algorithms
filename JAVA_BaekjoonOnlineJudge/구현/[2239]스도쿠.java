import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2239_Sudoku {
	
	static int zeroCnt;
	static boolean isFinish;
	static boolean[][] isRow, isColumn, isSquare;
	static int[][] board;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		board = new int[9][9];
		isRow = new boolean[9][10];
		isColumn = new boolean[9][10];
		isSquare = new boolean[9][10];
		for(int r=0; r<9; r++) {
			char[] temp = br.readLine().toCharArray();
			for(int c=0; c<9; c++) {
				int n = temp[c]-'0';
				board[r][c] = n;
				if(board[r][c] == 0) zeroCnt++;
				else {
					isRow[r][n] = true;
					isColumn[c][n] = true;
					isSquare[getSquareNum(r, c)][n] = true;
				}
			}
		}
		
		findNumber(0, 0, 0);
		System.out.println(sb);
	}	
	
	private static boolean findNumber(int cnt, int r, int c) {
		if(c == 9) {
			r+=1;
			c=0;
		}
		
		if(cnt == zeroCnt) {
			setPrint();
			return true;
		}
		
		if(board[r][c] != 0) return findNumber(cnt, r, c+1);
		int sNum = getSquareNum(r, c);
		for(int i=1; i<10; i++) {
			if(isRow[r][i] || isColumn[c][i] || isSquare[sNum][i]) continue;
			
			isRow[r][i] = isColumn[c][i] = isSquare[sNum][i] = true;
			board[r][c] = i;
			boolean flag = findNumber(cnt+1, r, c+1);
			if(flag) return true;
			
			isRow[r][i] = isColumn[c][i] = isSquare[sNum][i] = false;
			board[r][c] = 0;
		}
		
		return false;
	}
	
	private static int getSquareNum(int r, int c) {
		if(r<3) {
			if(c<3) return 0;
			else if(c<6) return 1;
			else return 2;
			
		} else if(r<6) {
			if(c<3) return 3;
			else if(c<6) return 4;
			else return 5;
			
		} else{
			if(c<3) return 6;
			else if(c<6) return 7;
			else return 8;
		}
	}

	private static void setPrint() {
		sb = new StringBuilder();
		for(int r=0; r<9; r++) {
			for(int c=0; c<9; c++) {
				sb.append(board[r][c]);
			}
			sb.append("\n");
		}
	}

}
