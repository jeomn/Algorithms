import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Button{
	int f;
	int t;
	Button(int f, int t){
		this.f = f;
		this.t = t;
	}
}

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] move = new int[] {U, -D};
		Button result = new Button(-1, -1);
		
		Queue<Button> route = new LinkedList<>();
		route.add(new Button(S, 0));
		boolean[] visited = new boolean[F+1]; 
		visited[S] = true;
		
		while(!route.isEmpty()) {
			Button b = route.poll();
			if(b.f == G) {
				System.out.println(b.t);
				return;
			}
			for(int i=0; i<2; i++) {
				int nf = b.f+move[i];
				
				if(nf<1 || nf>F) continue;
				if(visited[nf]) continue;
				
				route.add(new Button(nf, b.t+1));
				visited[nf] = true;
			}
		}
		System.out.println("use the stairs");
	}
}
