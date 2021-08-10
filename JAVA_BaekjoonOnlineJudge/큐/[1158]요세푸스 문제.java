//큐에 안넣고 그냥 Stringbuilder에 쌓았어도 됐을 것같다..


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1158_Josephus {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> numbers = new LinkedList<>();
		for(int i=1; i<=N; i++) {
			numbers.add(i);
		}
		
		Queue<Integer> josephus = new LinkedList<>();
		int idx = -1;
		while(!numbers.isEmpty()) {
			idx = (idx+K)%numbers.size();
			
			josephus.add(numbers.remove(idx--));
		} 
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=0; i<N; i++) {
			sb.append(josephus.poll()+", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}

}
