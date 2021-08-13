import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


class Enemy{
	int x;
	int y;

	Enemy(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class BOJ_17135_CastleDefence {
	
	static int N, M, D, maxKill;
	static int[][] board;
	static int[] myArcher;
	static HashMap<Enemy, Integer> enemies;
	static HashMap<Enemy, Integer> enemiesTemp;
	static boolean flag;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		board = new int[N][M];
		enemies = new HashMap<>();
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				int temp = Integer.parseInt(st.nextToken());
				board[r][c] = temp;
				if(temp==1) {
					enemies.put(new Enemy(r, c), 1);
				}
			}
		}
		
		enemiesTemp = new HashMap<>();
		myArcher = new int[3];
		setArcher(0, 0);
		
		System.out.println(maxKill);
	}
	
	
	private static void initEnemy() {
		for(Enemy e: enemies.keySet()) {
			enemiesTemp.put(e, 1);
		}
	}

	private static void setArcher(int cnt, int idx) {
		if(cnt == 3) {
			initEnemy();
			attackEnemy(myArcher);
			return;
		}
		
		for(int i=idx; i<M; i++) {
			myArcher[cnt] = i;
			setArcher(cnt+1, i+1);
		}
	}


	private static void attackEnemy(int[] archers) {
		int kill = 0;
		for(int n=0; n<N; n++) {
			ArrayList<Enemy> attack = new ArrayList<>();
			for(int i=0; i<3; i++) {
				int ax = N;
				int ay = archers[i];
				int target = Integer.MAX_VALUE;
				Enemy targetEnemy = new Enemy(-1, -1);
				for(Enemy e: enemiesTemp.keySet()) {
					int distance = Math.abs(e.x-ax) + Math.abs(e.y-ay);
					if(distance>D) continue;
					if(distance<target) {
						target = distance;
						targetEnemy = e;
					}else if(distance == target) {
						if(e.y < targetEnemy.y) {
							targetEnemy = e;
						}
					}
				}
				if(targetEnemy.x != -1)
					attack.add(targetEnemy);
			}
			for(Enemy e: attack) {
				if(enemiesTemp.containsKey(e)) {
					enemiesTemp.remove(e);
					kill++;
				}
			}
			moveEnemies();
		}
		maxKill = Math.max(maxKill, kill);	
	}


	private static void moveEnemies() {
		HashMap<Enemy, Integer> temp = new HashMap<>();
		for(Enemy e: enemiesTemp.keySet()) {
			if(e.x+1<N)
				temp.put(new Enemy(e.x+1, e.y), 1);
		}
		enemiesTemp = temp;
	}
}
