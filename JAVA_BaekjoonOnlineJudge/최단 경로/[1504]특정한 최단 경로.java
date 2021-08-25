import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, E;
	static final int INF = 100000000;
	static List[] graph;
	static class Node implements Comparable<Node>{
		int n;
		int w;
		Node(int n, int w){
			this.n = n;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N];
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, weight));
			graph[to].add(new Node(from, weight));
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken())-1;
		int v2 = Integer.parseInt(st.nextToken())-1;
		
		int[] route = new int[N];
		Arrays.fill(route, INF);
		int[] startRoute = findRoute(0, route);
		int[] v1Route = findRoute(v1, route);
		int[] v2Route = findRoute(v2, route);
		
		int result = Math.min(startRoute[v1]+v1Route[v2]+v2Route[N-1], 
				startRoute[v2]+v2Route[v1]+v1Route[N-1]);
		if(result >= INF) result = -1;
		System.out.println(result);
	}

	private static int[] findRoute(int start, int[] routeTemp) {
		PriorityQueue<Node> path = new PriorityQueue<>();
		path.add(new Node(start, 0));
		int[] route = Arrays.copyOf(routeTemp, N);
		route[start] = 0;
		
		while(!path.isEmpty()) {
			Node node = path.poll();
			
			if(route[node.n] < node.w) continue;
			
			for(int i=0; i<graph[node.n].size(); i++) {
				Node adj = (Node) graph[node.n].get(i);
				int nw = node.w + adj.w;
				if(route[adj.n] > nw) {
					route[adj.n] = nw;
					path.add(new Node(adj.n, nw));
				}
			}
		}
		
		return route;
	}

}
