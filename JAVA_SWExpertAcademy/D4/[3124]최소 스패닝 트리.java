import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int V, E;
	static int[] parents;
	static PriorityQueue<Node> graph;
	static class Node implements Comparable<Node>{
		int start;
		int end;
		int w;
		Node(int start, int end, int w){
			this.start = start;
			this.end = end;
			this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			return this.w-o.w;
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());		
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new PriorityQueue<>();
			
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				graph.add(new Node(A, B, C));
			}

			parents = new int[V+1];
			for(int i=0; i<V+1; i++) {
				parents[i] = i;
			}
			
			long result = Kruskal();
			
			System.out.println("#"+t+" "+result);
		}
	}
	
	private static int findParents(int n){
		if(parents[n] == n) return n;
		else return parents[n] = findParents(parents[n]);
	}
	
	private static boolean Union(int a, int b){
		int rootA = findParents(a);
		int rootB = findParents(b);
		
		if(rootA == rootB) return false;
		
		if(rootA < rootB) parents[rootB] = rootA;
		else parents[rootA] = rootB;
		
		return true;		
	}
	
	
	private static long Kruskal(){
		long sum = 0;
		for(int i=0; i<E; i++) {
			Node node = graph.poll();
			if(findParents(node.start) == findParents(node.end)) continue;
			if(Union(node.start, node.end)) {
				sum+=node.w;
			}
		}
		return sum;
	}
}
