import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String bit = sc.next();
			
			int count = bit.charAt(0) -'0';
			for(int i=1; i<bit.length(); i++) {
				if(bit.charAt(i-1) != bit.charAt(i))
					count++;
			}
            
			System.out.printf("#%d %d%n", test_case, count);		
		}
	}
}
