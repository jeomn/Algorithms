/**************************
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
			
			if(d==0 || d==1) s %= ((R-1)*2);
			else s %= ((C-1)*2);
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
				}
				if(temp[nr][nc] != null) {
					if(temp[nr][nc].z > shark.z) continue;
				}
				temp[nr][nc] = new Shark(shark.s, shark.d, shark.z);
			}
		}
		grid = temp;
		
	}

}

/**************************
*  HashMap으로 푼 거
**************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_17143_FishingKing2 {
	
	static int R, C, sharkSum;
	static boolean[][] isShark;
	static HashMap<Node, Shark> sharkMap;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static class Node{
		int r, c;
		Node(int r, int c){
			this.r = r;
			this.c= c;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this == obj) return true;
			Node other = (Node)obj;
			return this.r == other.r && this.c == other.c;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(r, c);
		}
	}
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
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		isShark = new boolean[R][C];
		sharkMap = new HashMap<>();
		for(int m=0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			
			if(d==0 || d==1) s %= ((R-1)*2);
			else s %= ((C-1)*2);
			isShark[r][c] = true;
			sharkMap.put(new Node(r, c), new Shark(s, d, z));
		}
		
		for(int i=0; i<C; i++) {
			catchShark(i);
			moveShark();
		}
		
		System.out.println(sharkSum);
	}

	private static void catchShark(int c) {
		for(int r=0; r<R; r++) {
			if(!isShark[r][c]) continue;
			Shark shark = sharkMap.get(new Node(r, c));
			sharkSum += shark.z;
			isShark[r][c] = false;
			return;
		}
	}

	private static void moveShark() {
		boolean[][] temp = new boolean[R][C];
		HashMap<Node, Shark> tempMap = new HashMap<>();
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(!isShark[r][c]) continue;
				Shark shark = sharkMap.get(new Node(r, c));
				
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
				}
				if(temp[nr][nc]) {
					if(tempMap.get(new Node(nr, nc)).z > shark.z) continue;
				}
				tempMap.put(new Node(nr, nc), new Shark(shark.s, shark.d, shark.z));
				temp[nr][nc] = true;
			}
		}
		isShark = temp;
		sharkMap = tempMap;
		
	}

}

