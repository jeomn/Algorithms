import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] values = new int[N+1];
		for(int i=2; i<=N; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			if(i%3 == 0)	temp.add(values[i/3]+1);
			if(i%2 == 0)	temp.add(values[i/2]+1);
			temp.add(values[i-1]+1);
			
			values[i] = Collections.min(temp);
		}
		
		System.out.println(values[N]);
	}
}
