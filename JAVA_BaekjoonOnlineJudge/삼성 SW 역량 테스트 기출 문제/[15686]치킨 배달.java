import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_15686_ChickenDelivery {
	
	static int M, minDistance;
	static int[] isChicken;
	static HashMap<Integer, int[]> house, chicken;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new HashMap<>();
		chicken = new HashMap<>();
		int hNum = 0, cNum = 0;
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				int temp = Integer.parseInt(st.nextToken());
				
				if(temp==1) {
					house.put(hNum++, new int[] {r, c});
				}else if(temp==2) {
					chicken.put(cNum++, new int[] {r, c});
				}
			}
		}
		
		isChicken = new int[M];
		minDistance = Integer.MAX_VALUE;
		findChickenDistance(0, 0);
		
		System.out.println(minDistance);
	}

	private static void findChickenDistance(int cnt, int idx) {
		if(cnt==M) {
			
			
			int sumDistance = 0;
			for(int i=0; i<house.size(); i++) {
				int[] h = house.get(i);
				
				int minTemp = Integer.MAX_VALUE;
				for(int j=0; j<M; j++) {
					int[] c = chicken.get(isChicken[j]);
					int d = Math.abs(c[0]-h[0]) + Math.abs(c[1]-h[1]);
					minTemp = Math.min(minTemp, d);
				}
				sumDistance += minTemp;
			}
			minDistance = Math.min(minDistance, sumDistance);
			return;
		}
		
		for(int i=idx; i<chicken.size(); i++) {
			isChicken[cnt] = i;
			findChickenDistance(cnt+1, i+1);
    }
	}
}
