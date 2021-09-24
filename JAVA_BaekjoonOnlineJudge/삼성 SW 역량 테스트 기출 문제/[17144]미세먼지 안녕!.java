import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17144_GoodByeFineDust {
	
	static int R, C, T;
	static int[][] room;
	static int acTop, acBottom;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		room = new int[R][C];
		boolean findAC = false;
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				room[r][c] = Integer.parseInt(st.nextToken());
				if(findAC && room[r][c] == -1) acBottom = r;
				else if(!findAC && room[r][c] == -1) {
					acTop = r;
					findAC = true;
				}
			}
		}
		
		for(int t=0; t<T; t++) {
			diffuseDust();
			runAirConditioner();
		}
		
		int sum=0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(room[r][c] == -1) continue;
				sum+=room[r][c];
			}
		}
		System.out.println(sum);
	}
	

	private static void diffuseDust() {
		int[][] tempRoom = new int[R][C];
		tempRoom[acTop][0] = -1;
		tempRoom[acBottom][0] = -1;
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(room[r][c] == -1 || room[r][c] == 0) continue;
				int dust = room[r][c];
				int dDust = dust/5;
				
				int cnt = 0;
				for(int i=0; i<4; i++) {
					int nr = r+dx[i];
					int nc = c+dy[i];
					
					if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
					if(room[nr][nc] == -1) continue;
					
					tempRoom[nr][nc] += dDust;
					cnt++;
				}
				tempRoom[r][c] += dust-(dDust*cnt);
			}
		}
		room = tempRoom;
	}
	
	
	private static void runAirConditioner() {
		int tr = acTop, tc = 1;
		int br = acBottom, bc = 1;
		
		int[][] tempRoom = new int[R][C];
		for(int r=0; r<R; r++) {
			System.arraycopy(room[r], 0, tempRoom[r], 0, C);
		}
		tempRoom[tr][tc] = 0;
		tempRoom[br][bc] = 0;
		
		int[] upOrder = new int[] {0, 1, 2, 3};
		int[] downOrder = new int[] {0, 3, 2, 1};
		for(int i=0; i<4; i++) {
			while(true) {
				int ntr = tr+dx[upOrder[i]];
				int ntc = tc+dy[upOrder[i]];
				
				if(ntr<0 || ntr>=R || ntc<0 || ntc>=C) break;
				if(room[ntr][ntc] == -1) break;
				tempRoom[ntr][ntc] = room[tr][tc];
				
				tr = ntr;
				tc = ntc;
			}
			
			while(true) {
				int nbr = br+dx[downOrder[i]];
				int nbc = bc+dy[downOrder[i]];
				
				if(nbr<0 || nbr>=R || nbc<0 || nbc>=C) break;
				if(room[nbr][nbc] == -1) break;
				tempRoom[nbr][nbc] = room[br][bc];
				
				br = nbr;
				bc = nbc;
			}
		}
		
		room = tempRoom;		
	}
}
