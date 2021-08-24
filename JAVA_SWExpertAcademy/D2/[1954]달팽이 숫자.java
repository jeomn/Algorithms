import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			
			int[] dx = {0, 1, 0, -1};
			int[] dy = {1, 0, -1, 0};
			
			int d = 0;
			int r = 0, c = -1;
			for(int num=1; num<=N*N; num++) {
				int nr = r+dx[d];
				int nc = c+dy[d];
				if(nr<0 || N<=nr || nc<0 || N<=nc || snail[nr][nc] != 0) {
					d = (d+1)%4;
				}
				r += dx[d];
				c += dy[d];
				snail[r][c] = num;
			}
            System.out.println("#"+t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}
}
