import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N, minValue = Integer.MAX_VALUE;
	static int[][] ability;
	static boolean[] isSelected;
	static boolean flag;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		ability = new int[N][N];
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				ability[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		isSelected = new boolean[N];
		findTeam(0, N);
		
		System.out.println(minValue);
		
	}

	private static void findTeam(int cnt, int falseNum) {
		if(flag) return;
		if(cnt == N) {
			if(falseNum == 0 || falseNum == N) return;
			calcAbility();
			return;
		}
		
		isSelected[cnt] = true;
		findTeam(cnt+1, falseNum-1);
		
		isSelected[cnt] = false;
		findTeam(cnt+1, falseNum);
	}

	private static void calcAbility() {
		int abilityA = 0;
		int abilityB = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++)
				if(isSelected[i] && isSelected[j])
					abilityA += (ability[i][j]+ability[j][i]);
				else if(!isSelected[i] && !isSelected[j])
					abilityB += (ability[i][j]+ability[j][i]);
		}
		minValue = Math.min(minValue, Math.abs(abilityA-abilityB));
		if(abilityA == 0) flag = true;
	}
}
