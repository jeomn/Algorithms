import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
	int x;
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int M, N, count;
	static int[][] warehouse;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		warehouse = new int[N][M];
		LinkedList<Node> tomatoes = new LinkedList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				warehouse[r][c] = temp;
				if(temp == 1)
					tomatoes.add(new Node(r, c));
			}
		}
		
		count = 0;
		ripenTomatoes(tomatoes);
		
		if(!checkTomatoes()) count = -1;
		else count = (count==0)? 0:count-1;
		System.out.println(count);
	}
	
	
	private static boolean checkTomatoes() {
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(warehouse[r][c] == 0) return false;
			}
		}
		return true;
	}


	private static void ripenTomatoes(LinkedList<Node> start) {
		Queue<Node> route = start;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!route.isEmpty()) {
			Node node = route.poll();
			
			for(int i=0; i<4; i++) {
				int nr = node.x + dx[i];
				int nc = node.y + dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(warehouse[nr][nc] != 0) continue;
				
				warehouse[nr][nc] = warehouse[node.x][node.y]+1;
				route.offer(new Node(nr, nc));
				count = Math.max(count,  warehouse[nr][nc]);
			}
		}
	}
}
