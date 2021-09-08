import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N, K;
	static boolean[] isRobot;
	static int[] belt;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		belt = new int[2*N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N*2; i++) {
			int d = Integer.parseInt(st.nextToken());
			belt[i] = d;
		}
		
		int step = 1;
		isRobot = new boolean[N];
		while(true) {
			moveBelt();
			isRobot[N-1] = false;
			
			moveRobot();
			isRobot[N-1] = false;
			
			putOn();
			
			if(checkDurability() >= K) break;
			step++;
		}
		System.out.println(step);
	}
	
	private static int checkDurability() {
		int cnt = 0;
		for(int i=0; i<2*N; i++) {
			if(belt[i] == 0) cnt++;
		}
		return cnt;
	}

	private static void putOn() {
		if(belt[0] != 0) {
			isRobot[0] = true;
			belt[0]--;
		}
	}

	private static void moveBelt() {
		int temp = belt[2*N-1];
		for(int i=2*N-1; i>0; i--) {
			belt[i] = belt[i-1];
		}
		belt[0] = temp;
		
		for(int i=N-1; i>0; i--) {
			isRobot[i] = isRobot[i-1];
		}
		isRobot[0] = false;
	}
	
	private static void moveRobot() {
		
		for(int i=N-1; i>0; i--) {
			if(isRobot[i]) continue;
			if(!isRobot[i-1]) continue;
			if(belt[i] == 0) continue;
			isRobot[i] = true;
			isRobot[i-1] = false;
			belt[i]--;
		}
	}
}
