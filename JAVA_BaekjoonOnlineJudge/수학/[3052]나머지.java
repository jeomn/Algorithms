import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<Integer> modNumber = new HashSet<>();
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(br.readLine());
			int result = num%42;
			modNumber.add(result);
		}
		System.out.println(modNumber.size());	
	}
}
