import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> front = new Stack<>();
		Stack<Integer> back = new Stack<>();
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num != 0){
				for(int j=0; j<num; j++) {
					back.add(front.pop());
				}
			}
			front.add(i);
			while(!back.empty()) {
				front.add(back.pop());
			}
		}
		
		ArrayList<Integer> order = new ArrayList<>();
		while(!front.isEmpty()) {
			order.add(front.pop());
		}
		while(!back.isEmpty()) {
			order.add(back.pop());
		}
		Collections.reverse(order);
		for(int i=0; i<N; i++) {
			System.out.print(order.get(i)+" ");
		}
	}
}
