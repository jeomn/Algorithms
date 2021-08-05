import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Tower{
	int idx;
	int height;
	
	Tower(int idx, int height){
		this.idx = idx;
		this.height = height;
	}
}


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		Stack<Tower> towers = new Stack<Tower>();
		ArrayList<Integer> result = new ArrayList<>();
		for(int i=1; i<=num; i++) {
			int h = Integer.parseInt(st.nextToken());
			Tower tower = new Tower(i, h); 
			
			while(!towers.isEmpty()) {
				Tower t = towers.peek();
				if(t.height >= h) {
					result.add(t.idx);
					towers.push(tower);
					break;
				}
				towers.pop();
			}
			if(towers.isEmpty())
				result.add(0);
			
			towers.push(tower);		
		}
		
		for(int n:result) {
			System.out.print(n+" ");
		}
	}	
}
