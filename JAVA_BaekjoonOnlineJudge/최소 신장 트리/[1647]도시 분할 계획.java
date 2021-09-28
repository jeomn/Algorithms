import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int[] parents;
	static PriorityQueue<Edge> edgeList;
	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edgeList = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(start, end, weight));
		}
		
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
		
		int cnt = 0, dist = 0;
		while(cnt < N-2) {
			Edge edge = edgeList.poll();
			if(union(edge.start, edge.end)) {
				dist += edge.weight;
				cnt++;
			}
		}
		
		System.out.println(dist);
	}


	private static int find(int n) {
		if(parents[n]==n) return n;
		return parents[n] = find(parents[n]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		if(rootA > rootB) {
			parents[rootB] = rootA;
		}else {
			parents[rootA] = rootB;
		}
		return true;
	}
}
