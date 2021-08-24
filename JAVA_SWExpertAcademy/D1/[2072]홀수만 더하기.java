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
            int result = 0;
			for(int i=1; i<11; i++){
                int num = sc.nextInt();
                if(num%2 != 0)
					result += num;
            }
			
            System.out.println("#"+test_case+" "+result);
		}
	}
}
