import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
	
	static HashMap<Integer, ArrayList<Integer>> graph;
	static int edgeSum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		graph = new HashMap<>();
		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer> value = graph.getOrDefault(n1, null);
			if(value==null) {
				value = new ArrayList<Integer>();
			}
			value.add(n2);
			graph.put(n1, value);
			
			value = graph.getOrDefault(n2, null);
			if(value==null) {
				value = new ArrayList<Integer>();
			}
			value.add(n1);
			graph.put(n2, value);
		}
		boolean[] visited = new boolean[N+1];
		countEdge(1, 0, visited);
		
		String result = (edgeSum%2)==0 ? "No":"Yes";
		System.out.println(result);
	}

	
	private static void countEdge(int node, int cnt, boolean[] visited) {
		visited[node] = true;
		for(int adj:graph.get(node)) {
			if(!visited[adj]) {
				countEdge(adj, cnt+1, visited);
			}
		}
		
		if(node!=1 && graph.get(node).size()==1) {
			edgeSum += cnt;
		}
	}
}
