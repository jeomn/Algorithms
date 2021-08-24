import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t=1; t<=10; t++) {
			br.readLine();
			int[][] ladders = new int[100][100];
			for(int r=0; r<100; r++) {
				String temp = br.readLine();
				StringTokenizer st = new StringTokenizer(temp);
				for(int c=0; c<100; c++) {
					ladders[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dx = {1, 0, 0};
			int[] dy = {0, -1, 1};
			int d = 0, result = -1;
			for(int start=0; start<100; start++) {
				if(ladders[0][start] == 0) continue;
				
				int r = 0, c = start;
				int nr = r, nc = c;
				boolean flag = false;
				while(r!=99) {
					for(int i=0; i<3; i++) {
						nr = r+dx[i];
						nc = c+dy[i];
						
						if(nr<0 || nr>99 || nc<0 || nc>99) continue;
						if(ladders[nr][nc] == 0) continue;
						
						if(i==1 && d==2) continue;
						if(i==2 && d==1) continue;
						d = i;
						r+=dx[d];
						c+=dy[d];
						if(ladders[r][c] == 2) {
							result = start;
							flag = true;
						}
					}
				}
				if(flag) break;
				
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
