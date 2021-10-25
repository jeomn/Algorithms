import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
	int x;
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class Main {
	
	static int N, M, minTime;
	static int[][] lab, labTemp;
	static LinkedList<Node> virusPossible;
	static Node[] virusTemp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		virusPossible = new LinkedList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 2) {
					virusPossible.add(new Node(r, c));
				}
				
				lab[r][c] = temp;
			}
		}
		
		minTime = Integer.MAX_VALUE;
		labTemp = new int[N][N];
		virusTemp = new Node[M];
		setVirus(0, 0);
		
		minTime = (minTime != Integer.MAX_VALUE)? minTime : -1;
		System.out.println(minTime);
	}
	
	
	private static void init() {
		for(int r=0; r<N; r++) {
			labTemp[r] = lab[r].clone();
		}
		
		for(int i=0; i<M; i++) {
			Node n = virusTemp[i];
			labTemp[n.x][n.y] = 3;
		}
	}
	
	
	private static void setVirus(int cnt, int idx) {
		if(cnt == M) {
			init();
			spreadVirus(virusTemp.clone());
			return;
		}
		
		for(int i=idx; i<virusPossible.size(); i++) {
			virusTemp[cnt] = virusPossible.get(i);
			setVirus(cnt+1, i+1);
		}
		
	}
	

	private static void spreadVirus(Node[] virus) {
		Queue<Node> route = new LinkedList<>();
		for(int i=0; i<M; i++)
			route.add(virus[i]);
		boolean[][] visited = new boolean[N][N];
		visited[route.peek().x][route.peek().y] = true;
		int time = 3;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!route.isEmpty()) {
			Node n = route.poll();
			
			for(int idx=0; idx<4; idx++) {
				int nr = n.x+dx[idx];
				int nc = n.y+dy[idx];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) continue;
				if(labTemp[nr][nc] == 1 || labTemp[nr][nc] == 3) continue;
				
				if(labTemp[nr][nc] == 0)
					time = Math.max(time, labTemp[n.x][n.y]+1);
				labTemp[nr][nc] = labTemp[n.x][n.y]+1;
				visited[nr][nc] = true;
				route.add(new Node(nr, nc));
				
			}
		}
		
		if(checkLab())
			minTime = Math.min(minTime, time-3);
	}
	
	
	private static boolean checkLab() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(labTemp[r][c] == 0)
					return false;
			}
		}
		return true;
	}
}



/*************************
* 20211025
* 연구소3 방문 횟수랑...해서 카운트 하는 건 왜 안되지 다시 해봐야지
*************************/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	static int N, M, minTime = Integer.MAX_VALUE;
	static int[][] lab, labTemp;
	static boolean[][] visited;
	static Node[] myVirus;
	static ArrayList<Node> virus;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		virus = new ArrayList<>();
		for(int x=0; x<N; x++) {
			st = new StringTokenizer(br.readLine());
			for(int y=0; y<N; y++) {
				lab[x][y] = Integer.parseInt(st.nextToken());
				if(lab[x][y] == 2) {
					virus.add(new Node(x, y));
				}
			}
		}
		
		myVirus = new Node[M];
		labTemp = new int[N][N];
		setVirus(0, 0);
		
		int result = (minTime==Integer.MAX_VALUE) ? -1:minTime;
		System.out.println(result);		
	}
	
	private static void init() {
		for(int r=0; r<N; r++) {
			System.arraycopy(lab[r], 0, labTemp[r], 0, N);
		}
		
		visited = new boolean[N][N];
		for(Node n: myVirus) {
			labTemp[n.x][n.y] = 3;
			visited[n.x][n.y] = true;
		}
	}
	
	private static void setVirus(int cnt, int idx) {
		if(cnt == M) {
			init();
			minTime = Math.min(minTime, spreadVirus());
			return;
		}
		
		for(int i=idx; i<virus.size(); i++) {
			myVirus[cnt] = virus.get(i);
			setVirus(cnt+1, i+1);
		}
	}

	private static int spreadVirus() {
		Deque<Node> route = new LinkedList<>();
		route.addAll(Arrays.asList(myVirus));
		
		int time = 3;
		while(!route.isEmpty()) {
			Node n = route.poll();
			
			for(int d=0; d<4; d++) {
				int nx = n.x+dx[d];
				int ny = n.y+dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(visited[nx][ny] || labTemp[nx][ny]==1) continue;
				
				if(labTemp[nx][ny] == 0) time = Math.max(time, labTemp[n.x][n.y]+1);
				labTemp[nx][ny] = labTemp[n.x][n.y]+1;
				route.add(new Node(nx, ny));
				visited[nx][ny] = true;
			}
		}
		
		if(checkLab()) return time-3;
		else return Integer.MAX_VALUE;
	}

	private static boolean checkLab() {
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(labTemp[r][c] == 0) return false; 
			}
		}
		return true;
	}
}
