import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_MakingBridge2 {
	
	static int N, M;
	static final int INF = 100000000;
	static int[][] map;
	static int[][] graph;
	static ArrayList<Node> graphList;
	static int[] parents;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Node implements Comparable<Node>{
		int x, y, w;
		Node(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int label = 2;	//섬 구별을 위한 라벨링
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(map[r][c] != 1) continue;
				setIslandNum(r, c, label++);
			}
		}
		
		graph = new int[label][label];
		for(int i=0; i<label; i++) {
			Arrays.fill(graph[i], INF);
			graph[i][i] = 0;
		}

		for(int i=0; i<2; i++) {	//섬끼리의 거리 재기
			setGraph(i);
		}

		graphList = new ArrayList<>();
		for(int i=2; i<label; i++) {
			for(int j=2; j<label; j++) {
				if(graph[i][j] == INF || graph[i][j] == 0) continue;
				Node temp = new Node(i, j, graph[i][j]);
				graphList.add(temp);
			}
		}
		
		Collections.sort(graphList);

		parents = new int[label];
		for(int i=0; i<label; i++) {
			parents[i] = i;
		}
		
		int minDistance = kruskal();
		
		for(int i=0; i<label; i++) {
			findParents(i);
		}
		
		int root = -1;
		boolean flag = true;
		for(int i=2; i<label-1; i++) {
			root = parents[i];
			if(parents[i+1] != root) {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println(minDistance);
		else System.out.println(-1);
	}


	private static void setIslandNum(int r, int c, int label) {
		Queue<Node> route = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		route.add(new Node(r, c, 0));
		visited[r][c] = true;
		map[r][c] = label;
		
		while(!route.isEmpty()) {
			Node node = route.poll();
			
			for(int i=0; i<4; i++) {
				int nr = node.x+dx[i];
				int nc = node.y+dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(visited[nr][nc] || map[nr][nc] == 0) continue;
				map[nr][nc] = label;
				visited[nr][nc] = true;
				route.add(new Node(nr, nc, 0));
			}
		}
	}
	
	
	private static void setGraph(int time) {
		int[][] tempIsland = map;
		if(time == 1) {
			tempIsland = new int[M][N];
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					tempIsland[c][r] = map[r][c];
				}
			}
		}
		
		for(int r=0; r<tempIsland.length; r++) {
			int start = 0, end = 0, startD = -1, distance = 0;
			for(int c=0; c<tempIsland[0].length-1; c++) {
				int current = tempIsland[r][c];
				if(startD == -1 && current == 0) continue;
				if(startD == -1 && current != 0 && tempIsland[r][c+1] == 0) {
					startD = c;
					start = tempIsland[r][c];
				}
				if(startD != -1 && current == 0 && tempIsland[r][c+1] != 0) {
					distance = c-startD;
					startD = -1;
					end = tempIsland[r][c+1];
					if(distance == 1) continue;
					if(distance<graph[start][end] && distance < graph[end][start]) {
						graph[start][end] = distance;
						graph[end][start] = distance;
					}
				}
			}
			startD = -1;
			distance = 0;
		}
	}
	
	
	private static int findParents(int i) {
		if(parents[i] == i) return i;
		return parents[i] = findParents(parents[i]);
	}
	
	
	private static boolean union(int a, int b) {
		int rootA = findParents(a);
		int rootB = findParents(b);
		
		if(rootA == rootB) return false;
		
		if(rootA < rootB) parents[rootB] = rootA;
		else parents[rootA] = rootB;
		
		return true;
	}
	
	
	private static int kruskal() {
		int sum = 0;
		for(int i=0; i<graphList.size(); i++) {
			Node node = graphList.get(i);
			if(union(node.x, node.y)) sum += node.w;
		}
		return sum;
	}

}
