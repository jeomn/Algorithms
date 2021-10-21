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



/***************************
* 20211021
* 복습 시간 효율이 더 
***************************/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	static int N, size = 2;
	static int[][] map;
	static PriorityQueue<Fish> fishList;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Fish implements Comparable<Fish>{
		int x, y, d;
		Fish(int x, int y, int d){
			this.x = x;
			this.y = y;
			this.d = d;
		}
		
		public int compareTo(Fish o) {
			int x = this.d - o.d;
			if(x == 0) {
				int y = this.x - o.x;
				if(y == 0) return this.y - o.y;
				return y;
			}
			return x;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		Fish shark = null;
		for(int r=0; r<N; r++) {
			st= new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 9) {
					shark = new Fish(r, c, 0);
					map[r][c] = 0;
				}
			}
		}
		
		fishList = new PriorityQueue<>();
		int ateFish = 0, time = 0;
		while(true) {
			findFish(shark);
			if(fishList.size() == 0) break;
			else {
				shark = fishList.poll();
				time += shark.d;
				shark.d = 0;
				map[shark.x][shark.y] = 0;
				
				ateFish++;
				if(ateFish == size) {
					ateFish = 0;
					size++;
				}
				
				fishList.clear();
			}
		}
		
		System.out.println(time);
	}

	private static void findFish(Fish start) {
		Deque<Fish> route = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		route.add(start);
		visited[start.x][start.y] = true;
		
		while(!route.isEmpty()) {
			Fish n = route.poll();
			
			for(int d=0; d<4; d++) {
				int nx = n.x+dx[d];
				int ny = n.y+dy[d];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(visited[nx][ny]) continue;
				
				int fish = map[nx][ny];
				
				if(fish > size) continue;
				else if(fish == 0 || fish == size) {
					visited[nx][ny] = true;
					route.add(new Fish(nx, ny, n.d+1));
				}else {
					visited[nx][ny] = true;
					fishList.add(new Fish(nx, ny, n.d+1));
				}
			}
		}
	}
}

