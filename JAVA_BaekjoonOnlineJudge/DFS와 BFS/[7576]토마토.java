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



/*
*	20210924
*	REVIEW 1
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_Tomatoes {
	
	static int N, M;
	static int[][] box;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		LinkedList<int[]> tomato = new LinkedList<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if(box[r][c] == 1) tomato.add(new int[] {r, c});
			}
		}
		
		int day = ripenTomatoes(tomato);
		check: for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(box[r][c] == 0) {
					day = -1;
					break check;
				}
			}
		}
		System.out.println(day);
	}
	
	
	private static int ripenTomatoes(LinkedList<int[]> start) {
		Queue<int[]> route = start;
		
		int day = 0;
		while(!route.isEmpty()) {
			int[] coord = route.poll();
			int r = coord[0];
			int c = coord[1];
			
			for(int i=0; i<4; i++) {
				int nr = r+dx[i];
				int nc = c+dy[i];
				
				if(nr<0 || nr>=N || nc<0 || nc>=M) continue;
				if(box[nr][nc] != 0) continue;
				
				route.add(new int[] {nr, nc});
				box[nr][nc] = box[r][c]+1;
				day = Math.max(day, box[nr][nc]-1);
			}
		}		
		
		return day;
	}
}
