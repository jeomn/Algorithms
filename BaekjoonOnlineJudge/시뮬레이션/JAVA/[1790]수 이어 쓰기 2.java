// 이분탐색


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		if(calcLength(N) < K) {
			System.out.println("-1");
			return;
		}
		
		int left = 1, mid = 0, right = N;
		int idx=0;
		while(left<=right) {
			mid = (left+right)/2;
			int length = calcLength(mid);
			if(length<K)
				left = mid+1;
			else {
				idx = mid;
				right = mid-1;
			}
		}
		
		String num = String.valueOf(idx);
		int iLength = calcLength(idx);
		
		System.out.println(num.charAt(num.length()-(iLength-K)-1));
	}
	
	
	private static int calcLength(int mid) {
		
		int length = 0, pLength = 1;
		for(int place=1; place<=mid; place*=10) {
			int range = place*10-1;
			if(range>mid)
				range = mid;
			length += ((range-place)+1)*pLength;
			++pLength;
		}
		return length;
	}
}
