import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		ArrayList<LinkedList<String>> dpList = new ArrayList<>();
		dpList.add(new LinkedList<>());
		dpList.get(0).add(String.valueOf(arr[0]));
		int maxCnt = 1, maxCntIdx = 0;
		for(int i=1; i<N; i++) {
			dpList.add(new LinkedList<>());
			dpList.get(i).add(String.valueOf(arr[i]));
			for(int j=i-1; j>=0; j--) {
				if(arr[j] < arr[i] && dpList.get(i).size() <= dpList.get(j).size()) {
					dpList.get(i).clear();
					dpList.get(i).add(String.valueOf(arr[i]));
					dpList.get(i).addAll(dpList.get(j));
					
					if(maxCnt < dpList.get(i).size()) {
						maxCnt = dpList.get(i).size();
						maxCntIdx = i;
					}
				}
			}
		}
		
		System.out.println(maxCnt);
		Collections.reverse(dpList.get(maxCntIdx));
		System.out.println(String.join(" ", dpList.get(maxCntIdx)));
	}
}
