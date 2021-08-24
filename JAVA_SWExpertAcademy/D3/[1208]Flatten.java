import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		for(int test=1; test<=10; test++) {
			int dump = Integer.parseInt(br.readLine());
			int[] boxes = new int[100];
			
			String strBoxes = br.readLine();
			StringTokenizer st = new StringTokenizer(strBoxes);
			for(int i=0; i<100; i++) {
				boxes[i] = Integer.parseInt(st.nextToken());
			}
			
			int maxInterval = 0;
			int minIdx = 0;
			int maxIdx = 0;
			for(int i=0; i<=dump; i++) {
				if(i!=0) {
					boxes[maxIdx]--;
					boxes[minIdx]++;
				}
				
				int minB = 101;
				int maxB = 0;
				for(int j=0; j<100; j++) {
					if(boxes[j] > maxB) {
						maxB = boxes[j];
						maxIdx = j;
					}
					if(boxes[j] < minB) {
						minB = boxes[j];
						minIdx = j;
					}
				}
				maxInterval = maxB-minB;
				if(maxInterval<2)
					break;
				
			}
			System.out.printf("#%d %d%n", test, maxInterval);

		}
	}
}
