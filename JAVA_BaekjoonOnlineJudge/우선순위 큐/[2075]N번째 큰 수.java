import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				numbers.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int num = -1;
		for(int i=0; i<N; i++) {
			num = numbers.poll();
		}
		System.out.println(num);
	}
}
