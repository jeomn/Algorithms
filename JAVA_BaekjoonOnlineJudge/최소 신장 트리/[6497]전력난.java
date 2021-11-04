import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int m;
	static long minWeight;
	static int[] parents;
	static PriorityQueue<Node> edgeList;
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
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			if(n==0 && m==0) break;
			
			edgeList = new PriorityQueue<>();
			int maxWeight = 0;
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				maxWeight+=w;
				edgeList.add(new Node(s, e, w));
			}
			
			parents = new int[m];
			for(int i=0; i<m; i++) {
				parents[i] = i;
			}
			
			minWeight = 0;
			kruskal();
			
			System.out.println(maxWeight-minWeight);
		}
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
		while(!edgeList.isEmpty()) {
			Node p = edgeList.poll();
			if(findParent(p.s) == findParent(p.e)) continue;
			minWeight += p.w;
			union(p.s, p.e);
		}
	}
}
