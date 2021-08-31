import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	static char[] input;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			input = br.readLine().toCharArray();
			int left=0;
			int right=input.length-1;
			int result = checkPalindraome(left, right, 0);
			System.out.println(result);
		}
	}

	private static int checkPalindraome(int l, int r, int flag) {
		if(flag == 2)
			return 2;
		
		int cnt = flag;
		while(l<=r) {
			if(input[l]!=input[r]) {
				int passLeft = checkPalindraome(l+1, r, flag+1);
				int passRight = checkPalindraome(l, r-1, flag+1);
				cnt = Math.min(passLeft, passRight);
				break;
			}
			l++;
			r--;
		}
		return cnt;
	}
}
