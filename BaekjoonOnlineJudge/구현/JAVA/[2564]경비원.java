
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int X = scan.nextInt();
		int Y = scan.nextInt();
		
		int snum = scan.nextInt();
		ArrayList<int[]> slist = new ArrayList<>();
		int dpx = 0;
		int dpy = 0;
		for(int i=0; i<snum+1; i++) {
			int dtmp = scan.nextInt();
			int tmp = scan.nextInt();
			
			int[] token = new int[2];
			switch(dtmp) {
				case 1:
					token = new int[] {tmp, Y};
					break;
				case 2:
					token = new int[] {tmp, 0};
					break;
				case 3:
					token = new int[] {0, Y-tmp};
					break;
				case 4:
					token = new int[] {X, Y-tmp};
					break;
			}
			if(i==snum) {
				dpx = token[0];
				dpy = token[1];
				break;
			}
			slist.add(token);

		}
		scan.close();

		int result = 0;
		for(int[] store: slist) {
			int sx = store[0];
			int sy = store[1];
			
			if(Math.abs(dpx-sx) == X) {	//동서
				result += (X + Math.min(dpy+sy, 2*Y-(dpy+sy)));
			}else if(Math.abs(dpy-sy) == Y) {	//남북
				result += (Y + Math.min(dpx+sx, 2*X-(dpx+sx)));
			}else {		//동근-가게가 일직선일 때
				result += (Math.abs(dpx-sx)+Math.abs(dpy-sy));
			}
		}
		System.out.println(result);
		
	}

}
