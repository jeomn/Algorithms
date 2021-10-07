import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int V, E;
	static int[] graphNum;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			for(int i=0; i<V; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int e=0; e<E; e++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken())-1;
				int b = Integer.parseInt(st.nextToken())-1;
				
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			graphNum = new int[V];
			boolean result = true;
			for(int i=0; i<V; i++) {
				if(graphNum[i] != 0) continue;
				result = setGraphNumber(i, 1);
				if(!result) break;
			}
			
			String answer = (result)? "YES":"NO";
			System.out.println(answer);
		}
	}

	private static boolean setGraphNumber(int start, int num) {
		Queue<Integer> route = new LinkedList<>();
		route.add(start);
		graphNum = new int[V];
		graphNum[start] = num;
		
		while(!route.isEmpty()) {
			int n = route.poll();
			for(int adj: graph.get(n)) {
				if(graphNum[n] == graphNum[adj]) return false;
				if(graphNum[adj] == 0) {
					graphNum[adj] = -graphNum[n];
					route.add(adj);
				}
			}
		}
		return true;
	}
}
