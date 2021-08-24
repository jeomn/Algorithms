import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
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

public class Main {
	
	static int V, E;
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] graph;
	static int[] route;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine())-1;
		graph = new ArrayList[V];
		for(int i=0; i<V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, weight));
		}
		
		route = new int[V];
		Arrays.fill(route, INF);
		route[K] = 0;
		Dijkstra(K, 0);
		for(int i=0; i<V; i++) {
			if(route[i] == INF)
				System.out.println("INF");
			else
				System.out.println(route[i]);
		}
	}

	private static void Dijkstra(int k, int d) {
		PriorityQueue<Node> path = new PriorityQueue<>();
		path.add(new Node(k, d));
		
		while(!path.isEmpty()) {
			Node node = path.poll();
			
			if(route[node.n] < node.w) continue;
			for(int i=0; i<graph[node.n].size(); i++) {
				Node adj = graph[node.n].get(i);
				
				int nw = node.w + adj.w;
				if(nw < route[adj.n]) {
					route[adj.n] = nw;
					path.add(new Node(adj.n, nw));
				}
			}
		}
	}
}
