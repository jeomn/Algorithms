import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static final long P = 1000000007;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long N = Integer.parseInt(st.nextToken());
		long K = Integer.parseInt(st.nextToken());
		
		long n = factorial(N);
		long p = factorial(K) * factorial(N-K)%P;
		System.out.println(n*calcPow(p, P-2)%P);
	}

	private static long factorial(long N) {
		long fac = 1;		
		while(N>1) {
			fac = (fac*N--)%P;
		}
		return fac;
	}
	
	private static long calcPow(long base, long expo) {
		if(expo == 0) return 1;
		else if(expo == 1) return base % P;
		if(expo%2 == 0) {
			long temp = calcPow(base, expo/2);
			return (temp*temp)%P;
		}else {
			long temp = calcPow(base, expo-1);
			return temp*base%P;
		}
	}
	
}
