import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
	
	static int N, K;
	static int[][] map, A;
	static int dn[] = {2, -1, 1};
	static class Node{
		int n, t;
		Node(int n, int t){
			this.n = n;
			this.t = t;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Deque<Node> route = new LinkedList<>();
		route.add(new Node(N, 0));
		boolean[] visited = new boolean[100001];
		visited[N] = true;
		while(!route.isEmpty()) {
			Node n = route.poll();
			
			if(n.n == K) {
				System.out.println(n.t);
				break;
			}
			
			for(int i=0; i<3; i++) {
				int nn = n.n+dn[i];
				if(i==0) {
					nn = n.n*dn[i];
				}
				
				if(nn<0 || nn>100000 || visited[nn]) continue;
				if(i==0) route.addFirst(new Node(nn, n.t));
				else route.offer(new Node(nn, n.t+1));
				visited[nn] = true;
			}
		}
	}
}
