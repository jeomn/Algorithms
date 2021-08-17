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
					temp = 0;
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
			labTemp[n.x][n.y] = 2;
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
		int time = 2;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!route.isEmpty()) {
			Node n = route.poll();
			
			for(int idx=0; idx<4; idx++) {
				int nr = n.x+dx[idx];
				int nc = n.y+dy[idx];
				
				if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
				if(labTemp[nr][nc] != 0) continue;
				
				labTemp[nr][nc] = labTemp[n.x][n.y]+1;
				route.add(new Node(nr, nc));		
				time = Math.max(time, labTemp[nr][nc]);
			}
		}
		
		if(checkLab())
			minTime = Math.min(minTime, time-2);
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
