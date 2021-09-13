import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int N, orderNum, minCnt = Integer.MAX_VALUE;
	static int[] open = new int[2];
	static int[] openOrder;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<2; i++) {
			open[i] = Integer.parseInt(st.nextToken())-1;
		}
		orderNum = Integer.parseInt(br.readLine());
		openOrder = new int[orderNum];
		for(int i=0; i<orderNum; i++) {
			openOrder[i] = Integer.parseInt(br.readLine())-1;
		}
		
		countOpenDoor(0, open, 0);
		System.out.println(minCnt);
	}


	private static void countOpenDoor(int idx, int[] arr, int count) {
		if(count >= minCnt) return;
		if(idx == orderNum) {
			minCnt = Math.min(minCnt, count);
			return;
		}
		
		int[] tempArr = null;
		if(Math.max(arr[0], arr[1]) < openOrder[idx]) {
			tempArr = new int[]{Math.min(arr[0], arr[1]), openOrder[idx]};
			countOpenDoor(idx+1, tempArr, count+openOrder[idx]-Math.max(arr[0], arr[1]));
		} else if(Math.min(arr[0], arr[1]) > openOrder[idx]) {
			tempArr = new int[]{Math.max(arr[0], arr[1]), openOrder[idx]};
			countOpenDoor(idx+1, tempArr, count+Math.min(arr[0], arr[1])-openOrder[idx]);
		} else {
			for(int i=0; i<2; i++) {
				tempArr = new int[]{arr[1-i], openOrder[idx]};
				countOpenDoor(idx+1, tempArr, count+Math.abs(openOrder[idx]-arr[i]));
			}
		}
		
	}
}
