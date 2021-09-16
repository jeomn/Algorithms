import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
	
	static final int INF = 103000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] nodes = new int[N+2][2];
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				nodes[i][0] = Integer.parseInt(st.nextToken());
				nodes[i][1] = Integer.parseInt(st.nextToken());
			}
			
			int[][] graph = new int[N+2][N+2];
			for(int i=0; i<N+2; i++) {
				Arrays.fill(graph[i], INF);
				for(int j=0; j<N+2; j++) {
					if(i==j) continue;
					int dist = Math.abs(nodes[i][0]-nodes[j][0]) + Math.abs(nodes[i][1]-nodes[j][1]);
					if(dist > 1000) continue;
					graph[i][j] = dist;
				}
			}
			
			for(int k=0; k<N+2; k++) {
				for(int i=0; i<N+2; i++) {
					if(i == k) continue;
					for(int j=0; j<N+2; j++) {
						if(i == j || k == j) continue;
						int dist = graph[i][k]+graph[k][j];
						if(graph[i][j] > dist) {
							graph[i][j] = dist;
						}
					}
				}
			}
			int result = graph[0][N+1];
			if(0<=result && result<103000) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}
