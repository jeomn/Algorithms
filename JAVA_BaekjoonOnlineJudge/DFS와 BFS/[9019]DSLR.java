import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Register{
	int num;
	int time;
	String operation;
	Register(int num, int time, String operation) {
		this.num = num;
		this.time = time;
		this.operation = operation;
	}
}

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			Queue<Register> route = new LinkedList<>();
			boolean[] visited = new boolean[10000];
			route.add(new Register(A, 0, ""));
			visited[A] = true;
			
			while(!route.isEmpty()) {
				Register r = route.poll();
				if(r.num == B) {
					System.out.println(r.operation);
					break;
				}
				for(int i=0; i<4; i++) {
					int nextNum = DSLR(i, r.num);
					if(visited[nextNum]) continue;
					
					route.add(new Register(nextNum, r.time+1, r.operation+setOperation(i)));
					visited[nextNum] = true;
				}
			}
		}
	}
	
	private static String setOperation(int i) {
		switch(i) {
		case 0:
			return "D";
		case 1:
			return "S";
		case 2:
			return "L";
		case 3:
			return "R";
		}
		return null;
	}

	private static int DSLR(int i, int num) {
		int result = 0;
		switch(i) {
			case 0:
				result = (num*2)%10000;
				break;
			case 1:
				if(num == 0)
					result = 9999;
				else
					result = num-1;
				break;
			case 2:
				int d1 = num/1000;
				result = (num%1000)*10+d1;
				break;
			case 3:
				int d4 = (num%10) *1000;
				result = num/10+d4;
				break;
		}
		return result;
	}
}
