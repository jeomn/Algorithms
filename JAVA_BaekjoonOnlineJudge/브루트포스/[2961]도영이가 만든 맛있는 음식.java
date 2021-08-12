import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961_DeliciousFoodByDoyoung {
	
	static int N;
	static int[] sourness, bitterness;
	static int food;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		sourness = new int[N];
		bitterness = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sourness[i] = Integer.parseInt(st.nextToken());
			bitterness[i] = Integer.parseInt(st.nextToken());
		}
		
		food = Integer.MAX_VALUE;
		makeFood(0, 1, 0);
		
		System.out.println(food);
	}

	private static void makeFood(int idx, int s, int b) {
		int taste = Math.abs(s-b);
		if(idx != 0 && s != 1)
			food = Math.min(food, taste);
		if(idx==N) return;
		
		makeFood(idx+1, s*sourness[idx], b+bitterness[idx]);
		makeFood(idx+1, s, b);
	}
}
