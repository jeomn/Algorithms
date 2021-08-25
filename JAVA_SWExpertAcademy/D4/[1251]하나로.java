import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int[] parents, level;
	static class Tunnel implements Comparable<Tunnel>{
		int v1;
		int v2;
		long length;
		Tunnel(int v1, int v2, long length){
			this.v1 = v1;
			this.v2 = v2;
			this.length = length;
		}
		@Override
		public int compareTo(Tunnel o) {
			return Long.compare(this.length, o.length);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1; test<=T; test++) {
			N = Integer.parseInt(br.readLine());
			
			int[][] coordinate = new int[N][2];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				coordinate[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				coordinate[i][1] = Integer.parseInt(st.nextToken());
			}
			
			double E = Double.parseDouble(br.readLine());
			
			Tunnel[] tunnels = new Tunnel[N*(N-1)/2];
			int idx = 0;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					tunnels[idx++] = new Tunnel(i, j, calcDistance(coordinate[i][0], coordinate[j][0], coordinate[i][1], coordinate[j][1]));
				}
			}
			
			parents = new int[N];
			level = new int[N];
			for(int i=0; i<N; i++) {
				parents[i] = i;
			}
			
			Arrays.sort(tunnels);
			idx = 0;
			long minValue = 0;
			for(int i=0; i<N*(N-1)/2; i++) {
				if(idx == N-1) break;
				int v1Root = find(tunnels[i].v1);
				int v2Root = find(tunnels[i].v2);
				if(v1Root == v2Root) continue;
				union(v1Root, v2Root);
				minValue += tunnels[i].length;
				idx++;
			}
			System.out.printf("#%d %d%n",test, Math.round(E*minValue));
		}
	}
	
	private static long calcDistance(int i, int j, int k, int l) {
		return (long)(Math.pow(i-j, 2)+Math.pow(k-l, 2));
	}
	
	
	private static int find(int v1) {
		if(parents[v1] == v1) return v1;
		return parents[v1] = find(parents[v1]);
	}
	
	private static void union(int v1Root, int v2Root) {
		
		if(level[v1Root] < level[v2Root]) {
			int temp = v1Root;
			v1Root = v2Root;
			v2Root = temp;
		}
		parents[v2Root] = v1Root;
		
		if(level[v1Root] == level[v2Root])
			level[v1Root]++;
	}
}
