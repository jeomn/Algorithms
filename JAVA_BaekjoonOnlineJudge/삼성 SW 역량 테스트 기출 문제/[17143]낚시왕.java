/**************************
*  
*  이차원 배열로 풀어본 거
**************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R, C, sharkSum;
	static Shark[][] grid;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static class Shark{
		int s, d, z;
		Shark(int s, int d, int z){
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//StringBuilder sb = new StringBuilder();
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		grid = new Shark[R][C];
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			grid[r][c] = new Shark(s, d, z);
		}
		
		for(int i=0; i<C; i++) {
			catchShark(i);
			moveShark();
		}
		
		System.out.println(sharkSum);

	}

	private static void catchShark(int c) {
		for(int r=0; r<R; r++) {
			if(grid[r][c] == null) continue;
			sharkSum += grid[r][c].z;
			grid[r][c] = null;
			return;
			
		}
	}

	private static void moveShark() {
		Shark[][] temp = new Shark[R][C];
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(grid[r][c] == null) continue;
				Shark shark = grid[r][c];
				
				int nr = r, nc = c;
				for(int s=0; s<shark.s; s++) {
					nr += dx[shark.d];
					nc += dy[shark.d];
					
					if(nr<0 || nr>=R) {
						nr -= (dx[shark.d]*2);
						shark.d = (shark.d == 0)? 1:0;
					}
					if(nc<0 || nc>=C) {
						nc -= (dy[shark.d]*2);
						shark.d = (shark.d == 2)? 3:2;
					}
					//System.out.println(nr+" "+nc);
				}
				if(temp[nr][nc] != null) {
					if(temp[nr][nc].z > shark.z) continue;
				}
				temp[nr][nc] = new Shark(shark.s, shark.d, shark.z);
				//System.out.println("상어 이동: "+shark.s+"칸 "+r+" "+c+" to "+nr+" "+nc+" "+shark.d);
			}
		}
		grid = temp;
		
	}

}
