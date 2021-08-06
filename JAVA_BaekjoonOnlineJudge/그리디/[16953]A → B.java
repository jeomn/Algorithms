import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int num = scan.nextInt();
		int changeNum = scan.nextInt();
		
		int count = 1;
		while(changeNum != num) {
			if(changeNum < num) {
				count = -1;
				break;
			}
			
			if(changeNum%2 == 0)
				changeNum/=2;
			else if(changeNum%10 == 1)
				changeNum/=10;
			else {
				count = -1;
				break;
			}

			count++;
		}
		System.out.println(count);
		
	}

}
