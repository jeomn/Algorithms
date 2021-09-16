import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
    static ArrayList<Integer> numArr;
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		numArr = new ArrayList<>();
		numArr.add(Integer.MIN_VALUE);
		int[] arrIdx = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if(numArr.get(numArr.size()-1) < arr[i]) {
				numArr.add(arr[i]);
				arrIdx[i] = numArr.size()-1;
			}else {
				int idx = lowerBound(arr[i]);
				numArr.set(idx, arr[i]);
				arrIdx[i] = idx;
			}
		}
		
		int length = numArr.size()-1;
		sb.append(length+"\n");
		
		Stack<Integer> sequence = new Stack<>();
		for(int i=N-1; i>=0; i--) {
			if(length == 0) break;
			if(arrIdx[i] == length) {
				sequence.add(arr[i]);
				length--;
			}
		}
		while(!sequence.isEmpty()) {
			sb.append(sequence.pop()+" ");
		}
		System.out.println(sb);
	}
	
	
	private static int lowerBound(int target) {
		int start = 0, end = numArr.size()-1;
		int mid = 0;
		
		while(start<end) {
			mid = (start+end)/2;
			if(numArr.get(mid) < target) start = mid+1;
			else end = mid;
		}
		return end;
	}
}
