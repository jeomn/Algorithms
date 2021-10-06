import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, minDiffer = Integer.MAX_VALUE;
	static int[] population;
	static boolean[] isAreaA;
	static int[][] graph;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		population = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		graph = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j=0; j<n; j++) {
				int adj = Integer.parseInt(st.nextToken());
				graph[i][adj] = 1;
				graph[adj][i] = 1;
			}
		}
		
		isAreaA = new boolean[N+1];
		setArea(0, 1);
		
		if(minDiffer == Integer.MAX_VALUE) minDiffer = -1;
		System.out.println(minDiffer);
	}

	private static void setArea(int cnt, int idx) {
		if(idx == N+1) {
			if(cnt == 0 || cnt >= N) return;
			setGerrymadering();
			return;
		}
		
		isAreaA[idx] = true;
		setArea(cnt+1, idx+1);
		isAreaA[idx] = false;
		setArea(cnt, idx+1);
	}

	private static void setGerrymadering() {
		if(!isConnect()) return;
		
		int sumA = 0, sumB = 0;
		for(int i=1; i<=N; i++) {
			if(isAreaA[i]) sumA += population[i];
			else sumB += population[i];
		}
		
		minDiffer = Math.min(minDiffer, Math.abs(sumA-sumB));
	}

	private static boolean isConnect() {
		int startA = -1;
		int startB = -1;
		for(int i=1; i<=N; i++) {
			if(startA == -1 && isAreaA[i]) startA = i;
			else if(startB == -1 && !isAreaA[i]) startB = i;;
			
			if(startA != -1 && startB != -1) break;
		}
		
		//A area
		Queue<Integer> route = new LinkedList<>();
		route.offer(startA);
		boolean[] visited = new boolean[N+1];
		visited[startA] = true;
		
		while(!route.isEmpty()) {
			int n = route.poll();
			
			for(int adj=1; adj<=N; adj++) {
				if(graph[n][adj] == 0) continue;
				if(visited[adj] || !isAreaA[adj]) continue;

				visited[adj] = true;
				route.add(adj);
			}
		}
		
		//B area
		route.offer(startB);
		visited[startB] = true;

		while(!route.isEmpty()) {
			int n = route.poll();
			
			for(int adj=1; adj<=N; adj++) {
				if(graph[n][adj] == 0) continue;
				if(visited[adj] || isAreaA[adj]) continue;

				visited[adj] = true;
				route.add(adj);
			}
		}
		
		for(int i=1; i<=N; i++) {
			if(!visited[i]) return false;
		}
		return true;
	}
}
