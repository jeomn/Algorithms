import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int n;
	static double minWeight;
	static double[][] graph;
	static int[] parents;
	static PriorityQueue<Node> edgeList;
	static class Node implements Comparable<Node>{
		int s, e;
		double w;
		Node(int s, int e, double w){
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		public int compareTo(Node o) {
			return Double.compare(this.w, o.w);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
			n = Integer.parseInt(br.readLine());
			
			graph = new double[n][2];
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				graph[i][0] = Double.parseDouble(st.nextToken());
				graph[i][1] = Double.parseDouble(st.nextToken());
			}
			
			edgeList = new PriorityQueue<>();
			for(int i=0; i<n; i++) {
				for(int j=i+1; j<n; j++) {
					double w = getDistance(graph[i], graph[j]);
					edgeList.add(new Node(i, j, w));
				}
			}			
			
			parents = new int[n];
			for(int i=0; i<n; i++) {
				parents[i] = i;
			}
			
			kruskal();
			
			System.out.printf("%.2f", minWeight);
	}
	
	private static double getDistance(double[] a, double[] b) {
		double x = Math.pow(Math.abs(a[0]-b[0]), 2);
		double y = Math.pow(Math.abs(a[1]-b[1]), 2);
		return Math.pow(Math.abs(x+y), 0.5);
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
