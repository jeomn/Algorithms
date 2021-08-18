import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1992_QuadTree {
	
	static int[][] image;
	static LinkedList<Character> result;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		image = new int[N][N];
		for(int r=0; r<N; r++) {
			char[] temp = br.readLine().toCharArray();
			for(int c=0; c<N; c++) {
				image[r][c] = temp[c] - '0';
			}
		}
		
		result = new LinkedList<>();
		compression(0, 0, N);
		
		StringBuilder sb = new StringBuilder();
		for(char r:result) {
			sb.append(r);
		}
		System.out.println(sb);
	}


	private static void compression(int x, int y, int n) {
		
		int count = 0;
		for(int r=x; r<x+n; r++) {
			for(int c=y; c<y+n; c++) {
				count += image[r][c];
			}
		}
		if(count%(n*n) == 0) {
			if(count == 0)
				result.add('0');
			else
				result.add('1');
			return;
			
		}else {
			result.add('(');
			compression(x, y, n/2);
			compression(x, y+n/2, n/2);
			compression(x+n/2, y, n/2);
			compression(x+n/2, y+n/2, n/2);
			result.add(')');
		}
	}
}
