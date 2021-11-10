import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int H, W;
	static int[] world;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		world = new int[W];
		st = new StringTokenizer(br.readLine());
		for(int c=0; c<W; c++) {
			world[c] = Integer.parseInt(st.nextToken());
		}
		
		int total = 0, idx=0, rain=0;
		for(int i=0; i<W; i++) {
			idx=0;
			int lIdx = 0, lHeight=world[lIdx];
			while(idx<=i) {
				if(world[idx] >= lHeight) {
					lHeight = world[idx];
					lIdx = idx;
				}
				idx++;
			}
			idx=W-1;
			int rIdx = W-1, rHeight=world[rIdx];
			while(idx>=i) {
				if(world[idx] >= rHeight) {
					rHeight = world[idx];
					rIdx = idx;
				}
				idx--;
			}
			
			rain = Math.min(lHeight, rHeight);
			total += Math.abs(rain-world[i]);
		}
		
		System.out.println(total);
	}
}
