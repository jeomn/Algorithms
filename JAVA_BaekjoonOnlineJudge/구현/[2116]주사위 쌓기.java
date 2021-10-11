import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[][] dices;
	static int[] diceNum;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		dices = new int[N][6];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<6; j++) {
				dices[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		diceNum = new int[N];
		int maxSum = 0;
		for(int i=0; i<6; i++) {
			int	down=i, up=getIdx(i);
			int sum = 0;
			
			//차례대로 올라가기
			for(int n=0; n<N; n++) {
				int max = Integer.MIN_VALUE;
				for(int j=0; j<6; j++) {	//최댓값 옆면 찾기
					if(j==down || j==up) continue;
					max = Math.max(max, dices[n][j]);
				}
				sum+=max;
				
				if(n==N-1) continue;
				int find = dices[n][up];	//위에 올릴 주사위 면 찾기
				for(int j=0; j<6; j++) {
					if(dices[n+1][j] == find) {
						down = j;
						up = getIdx(j);
						break;
					}
				}
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		System.out.println(maxSum);		
	}

	private static int getIdx(int idx) {
		if(idx == 0) return 5;
		else if(idx == 1) return 3;
		else if(idx == 2) return 4;
		else if(idx == 3) return 1;
		else if(idx == 4) return 2;
		else if(idx == 5) return 0;
		
		return -1;
	}
}
