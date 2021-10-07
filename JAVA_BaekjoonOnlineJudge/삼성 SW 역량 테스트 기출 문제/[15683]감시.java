import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, cameraNum, minBlind;
	static int[][] office;
	static ArrayList<int[]> cctvs;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][][] cameraD = {
			{{0}, {1}, {2}, {3}},
			{{0, 2}, {1, 3}},
			{{0, 1}, {1, 2}, {2, 3}, {3, 0}},
			{{0, 1, 3}, {0, 1, 2}, {1, 2, 3}, {2, 3, 0}},
			{{0, 1, 2, 3}}};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int blind = N*M;
		office = new int[N][M];
		cctvs = new ArrayList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				office[r][c] = temp;
				if(temp == 0) continue;
				else if(temp == 6) blind--;
				else
					cctvs.add(new int[] {r, c, temp-1});
			}
		}
		cameraNum = cctvs.size();
		
		minBlind = Integer.MAX_VALUE;
		setCamera(0, blind-cameraNum, office);
		System.out.println(minBlind);
	}
	
	
	private static void init(int[][] source, int[][] copyTemp) {
		for(int i=0; i<N; i++) {
			System.arraycopy(source[i], 0, copyTemp[i], 0, M);
		}
	}
	
	
	private static void setCamera(int cameraIdx, int cnt, int[][] currentOffice) {
		if(cameraIdx == cameraNum) {
			minBlind = Math.min(minBlind, cnt);
			return;
		}
		
		int[] camera = cctvs.get(cameraIdx);
		int r = camera[0];
		int c = camera[1];
		int d = camera[2];
		int[][] officeTemp = new int[N][M];
		for(int[] directions : cameraD[d]) {
			int cntTemp = 0;
			init(currentOffice, officeTemp);
			for(int dirc : directions) {
				int nr = r+dx[dirc];
				int nc = c+dy[dirc];
				
				while(0<=nr && nr<N && 0<=nc && nc<M) {
					if(officeTemp[nr][nc] == 6) break;
					else if(officeTemp[nr][nc] == 0){
						officeTemp[nr][nc] = -1;
						cntTemp++;
					}
					nr += dx[dirc];
					nc += dy[dirc];
				}
			}
			setCamera(cameraIdx+1, cnt-cntTemp, officeTemp);
		}
	}
}



/************************
* 20211007
************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, minCnt = Integer.MAX_VALUE;
	static int[][] office, officeSub;
	static ArrayList<Camera> cctvList;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][][] cctvDirection = new int[][][]{
		{{3}, {0}, {1}, {2}},
		{{2, 3}, {0, 1}},
		{{0, 3}, {3, 1}, {1, 2}, {2, 0}},
		{{2, 0, 3}, {0, 3, 1}, {3, 1, 2}, {1, 2, 0}},
		{{0, 1, 2, 3}}
	};
	static class Camera{
		int x, y, n;
		Camera(int x, int y, int n){
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		office = new int[N][M];
		cctvList = new ArrayList<>();
		int blind = N*M;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				office[r][c] = temp;
				
				if(temp == 0) continue;
				blind--;
				if(temp == 6) continue;
				cctvList.add(new Camera(r, c, office[r][c]-1));
			}
		}
		
		officeSub = new int[N][M];
		copyOffice(office, officeSub);
		setCctv(0, 0, blind);
		
		System.out.println(minCnt);
	}


	private static void setCctv(int cnt, int idx, int blind) {
		if(cnt == cctvList.size()) {
			minCnt = Math.min(minCnt, blind);
			return;
		}
		if(idx >= cctvList.size()) return;
		
		int[][] officeTemp = new int[N][M];
		copyOffice(officeSub, officeTemp);
		Camera c = cctvList.get(idx);
		for(int i=0; i<cctvDirection[c.n].length; i++) {
			int bCnt = 0;
			for(int j=0; j<cctvDirection[c.n][i].length; j++) {
				int nx = c.x;
				int ny = c.y;
				int d = cctvDirection[c.n][i][j];
				while(true) {
					nx += dx[d];
					ny += dy[d];
					if(nx<0 || nx>=N || ny<0 || ny>=M) break;
					if(officeSub[nx][ny] == 0) {
						officeSub[nx][ny] = -1;
						bCnt++;
					} else if(officeSub[nx][ny] == 6) break;
					
				}
			}
			setCctv(cnt+1, idx+1, blind-bCnt);
			copyOffice(officeTemp, officeSub);
		}	
	}

	private static void copyOffice(int[][] origin, int[][] copy) {
		for(int r=0; r<N; r++) {
			System.arraycopy(origin[r], 0, copy[r], 0, M);
		}
	}
}
