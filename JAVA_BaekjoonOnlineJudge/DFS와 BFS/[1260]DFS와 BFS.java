import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_DFSansBFS {
	
	static int N, M;
	static boolean[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		graph = new boolean[N+1][N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s][e] = true;
			graph[e][s] = true;
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		bfs(V);
	}

	private static void dfs(int start) {
		
		visited[start] = true;
		System.out.print(start+" ");
		for(int i=0; i<N+1; i++) {
			if(graph[start][i] && !visited[i]) {
				dfs(i);
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> route = new LinkedList<>();
		boolean[] visited = new boolean[N+1]; 
		route.add(start);
		visited[start] = true;
		
		while(!route.isEmpty()) {
			int node = route.poll();
			
			System.out.print(node+" ");
			for(int i=0; i<N+1; i++) {
				if(graph[node][i] && !visited[i]) {
					route.add(i);
					visited[i] = true;
				}
			}
		}
	}
}
