//플루이드 워샬

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static final int INF = 1000000000;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] graph = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				graph[r][c] = INF;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken())-1;
			int n2 = Integer.parseInt(st.nextToken())-1;
			graph[n1][n2] = 1;
			graph[n2][n1] = 1;
		}
		
		for(int via=0; via<N; via++) {
			for(int start=0; start<N; start++) {
				for(int end=0; end<N; end++) {
					graph[start][end] = Math.min(graph[start][via]+graph[via][end], graph[start][end]);
				}
			}
		}
		
		int minSum = INF, minFriend = -1;
		for(int r=0; r<N; r++) {
			int edgeSum = 0;
			for(int c=0; c<N; c++) {
				if(r==c) continue;
				edgeSum += graph[r][c];
			}
			if(edgeSum<minSum) {
				minSum = edgeSum;
				minFriend = r+1;
			}
		}
		
		System.out.println(minFriend);
	}
}
