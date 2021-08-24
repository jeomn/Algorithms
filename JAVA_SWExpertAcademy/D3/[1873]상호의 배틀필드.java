import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{	
  static int H, W;
	static char[][] field;
	static int[] tank;
	static int tankD;
	static char[] tankShape = {'^', 'v', '<', '>'};
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			field = new char[H][W];
			for(int r=0; r<H; r++) {
				char[] tempLine = br.readLine().toCharArray();
				for(int c=0; c<W; c++) {
					char temp = tempLine[c];
					field[r][c] = temp;
					
					if(temp=='^' || temp=='v' || temp=='<' || temp=='>') {
						field[r][c] = '.';
						tank = new int[] {r, c};
						for(int i=0; i<4; i++) {
							if(temp == tankShape[i]) {
								tankD = i;
								break;
							}
						}
					}
				}
			}
			
			br.readLine();
			char[] command = br.readLine().toCharArray();
			
			for(char cmd: command) {
				if(cmd=='S')
					shooting();
				else
					moveDirection(cmd);
			}
			
			field[tank[0]][tank[1]] = tankShape[tankD];
			
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test+" ");
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++)
					sb.append(field[i][j]);
                if(i == H-1) continue;
				sb.append("\n");
			}
			System.out.println(sb);
		}
	}


	private static void shooting() {
		int x = tank[0];
		int y = tank[1];
		
		int nx = x, ny = y;
		while(true) {
			nx += dx[tankD];
			ny += dy[tankD];
			
			if(nx<0 || H<=nx || ny<0 || W<=ny) break;
			if(field[nx][ny]=='#') break;
			
			if(field[nx][ny]=='*') {
				field[nx][ny] = '.';
				break;
			}
		}
	}


	private static void moveDirection(char cmd) {
		
		if(cmd=='U') {
			tankD = 0;
		}else if(cmd=='D') {
			tankD = 1;
		}else if(cmd=='L') {
			tankD = 2;
		}else if(cmd=='R') {
			tankD = 3;
		}
		
		int x = tank[0];
		int y = tank[1];
		
		int nx = x+dx[tankD];
		int ny = y+dy[tankD];
		if(nx<0 || H<=nx || ny<0 || W<=ny || field[nx][ny] != '.') return;
		
		tank[0] = nx;
		tank[1] = ny;
	}
}
