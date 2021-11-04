import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static long minWeight;
	static int[] parents;
	static PriorityQueue<Node> planets;
	static class Node implements Comparable<Node>{
		int s, e, w;
		Node(int s, int e, int w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		planets = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			planets.add(new Node(s, e, w));
		}
		
		parents = new int[N];
		for(int i=0; i<N; i++) {
			parents[i] = i;
		}
		
		kruskal();
		
		System.out.println(minWeight);
	}
	
	public static int findParent(int n) {
		if(parents[n] == n) return n;
		else return parents[n] = findParent(parents[n]);
	}
	
	public static void union(int a, int b) {
		int rootA = findParent(a);
		int rootB = findParent(b);
		
		if(rootA == rootB) return;
		if(rootA < rootB) parents[rootB] = rootA;
		else parents[rootA] = rootB;
	}
	
	public static void kruskal() {
		while(!planets.isEmpty()) {
			Node p = planets.poll();
			if(findParent(p.s) == findParent(p.e)) continue;
			minWeight += p.w;
			union(p.s, p.e);
		}
	}
}
