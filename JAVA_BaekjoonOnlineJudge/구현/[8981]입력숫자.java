import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N;
	static int[] X, Y;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		Y = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			Y[i] = Integer.parseInt(st.nextToken());
		}
		
		X = new int[N];
		int idx = 0;
		for(int i=0; i<N; i++) {
			int value = X[idx];
			idx = (idx+value)%N;
			while(X[idx] != 0) idx = (idx+1)%N;
			X[idx] = Y[i];
		}
		
		System.out.println(N);
		for(int i=0; i<N; i++) {
			System.out.printf("%d ", X[i]);
		}

	}
}
