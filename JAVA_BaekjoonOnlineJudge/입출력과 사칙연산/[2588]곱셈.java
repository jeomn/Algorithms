import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int c3 = a*(b%10);
		System.out.println(c3);
		int c4 = a*((b/10)%10);
		System.out.println(c4);
		int c5 = a*(b/100);
		System.out.println(c5);
		System.out.println(c3+(c4*10)+(c5*100));
	}
}
