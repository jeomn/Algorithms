import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1074_Z {
	
	static int r, c, idx, num;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		int n = (int)Math.pow(2, N);
		
		num = -1;
		visitField(0, 0, n);
		
		System.out.println(num);
	}

	private static void visitField(int x, int y, int n) {
		if(num != -1) return;
		
		if(n == 2) {
			int[] dx = {0, 0, 1, 1};
			int[] dy = {0, 1, 0, 1};
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				
				if(nx == r && ny == c) {
					num = idx;
				}
				idx++;
			}
			return;
		}
		
		if(r < x+n/2 && c < y+n/2) {
			visitField(x, y, n/2);
			
		}else if(r < x+n/2 && c>=y+n/2) {
			idx += Math.pow(n/2, 2);
			visitField(x, y+n/2, n/2);
			
		}else if(r>= x+n/2 && c<y+n/2) {
			idx  += Math.pow(n/2, 2) * 2;
			visitField(x+n/2, y, n/2);
			
		}else {
			idx += Math.pow(n/2, 2) * 3;
			visitField(x+n/2, y+n/2, n/2);
		}
	}
}
