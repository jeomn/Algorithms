import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int N = Integer.parseInt(br.readLine());
		int[][] house = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int[][] color = new int[N][3];
		color[0] = Arrays.copyOf(house[0], 3);
		for(int i=1; i<N; i++) {
			color[i][0] = house[i][0] + Math.min(color[i-1][1], color[i-1][2]); 
			color[i][1] = house[i][1] + Math.min(color[i-1][0], color[i-1][2]); 
			color[i][2] = house[i][2] + Math.min(color[i-1][0], color[i-1][1]); 
		}
		
		System.out.println(Arrays.stream(color[N-1]).min().getAsInt());
	}
}
