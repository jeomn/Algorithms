import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> positiveNum = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negativeNum = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp >= 0)
				positiveNum.add(temp);
			else
				negativeNum.add(temp);
		}
		
		int maxWalk = 0;
		int totalWalk = 0;
		while(!positiveNum.isEmpty()) {
			int big = 0;
			for(int i=0; i<M; i++) {
				if(positiveNum.isEmpty()) continue;
				big = Math.max(big, positiveNum.poll());
			}
			
			totalWalk += big;
			maxWalk = Math.max(maxWalk, big);
		}
		
		while(!negativeNum.isEmpty()) {
			int big = 0;
			for(int i=0; i<M; i++) {
				if(negativeNum.isEmpty()) continue;
				big = Math.max(big, Math.abs(negativeNum.poll()));
			}
			
			totalWalk += big;
			maxWalk = Math.max(maxWalk, big);
		}
		
		System.out.println(totalWalk*2-maxWalk);
	}
}
