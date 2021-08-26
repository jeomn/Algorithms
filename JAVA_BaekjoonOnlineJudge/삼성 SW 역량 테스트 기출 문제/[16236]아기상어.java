import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	int x;
	int y;
	int d;
	
	Node(int x, int y, int d){
		this.x = x;
		this.y = y;
		this.d = d;
	}

	@Override
	public int compareTo(Node o) {
		int result = this.d - o.d;
		if(result == 0) {
			int subResult = this.x - o.x;
			if(subResult == 0)
				return this.y - o.y;
			else
				return subResult;
		}
		return result;
	}
}


public class Main {
	
	static int N, size = 2;
	static int[][] field;
	static Node babyShark;
	static LinkedList<Node> fish;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		field = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp == 9) {
					babyShark = new Node(r, c, 0);
					temp = 0;
				}
				field[r][c] = temp;
			}
		}
		
		fish = new LinkedList<>();
		int time = 0, eatCnt = 0;
		while(true) {
			boolean isEat = eatFish(babyShark);
			Collections.sort(fish);
			if(isEat) {
				Node eat = fish.pollFirst();
				time += eat.d;
				eatCnt++;
				if(eatCnt == size) {
					size++;
					eatCnt = 0;
				}
				babyShark = eat;
				babyShark.d = 0;
				field[babyShark.x][babyShark.y] = 0;
				
			} else
				break;
			
			fish.clear();
		}
		
		System.out.println(time);
	}

	
	private static boolean eatFish(Node start) {
		Queue<Node> route = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		route.add(start);
		visited[start.x][start.y] = true;
		boolean isEat = false;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		while(!route.isEmpty()) {
			Node node = route.poll();
			
			for(int idx=0; idx<4; idx++) {
				int nx = node.x+dx[idx];
				int ny = node.y+dy[idx];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(visited[nx][ny] || field[nx][ny] > size) continue;
				
				if(field[nx][ny] == size || field[nx][ny] == 0) {
					visited[nx][ny] = true;
					route.add(new Node(nx, ny, node.d+1));
				} else if(field[nx][ny] < size) {
					visited[nx][ny] = true;
					fish.add(new Node(nx, ny, node.d+1));
					isEat = true;
				}
			}
		}
		return isEat;
	}
}
