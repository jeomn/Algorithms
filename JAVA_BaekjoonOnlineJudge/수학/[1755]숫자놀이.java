import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	
	//문자열 변환을 위한 숫자-문자열 배열
	static String[] stringNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//데이터 입력을 위한 BufferedReader
		StringTokenizer st = new StringTokenizer(br.readLine());	//데이터를 띄어쓰기 단위로 끊기 위한 StringTokenizer
		StringBuilder sb = new StringBuilder();		//문자열을 합치기 위한 StringBuilder
		
		int M = Integer.parseInt(st.nextToken());	//정수 M 받아오기
		int N = Integer.parseInt(st.nextToken());	//정수 N 받아오기
		
		HashMap<String, Integer> numMap = new HashMap<>();	//숫자를 읽은 문자열을 Key로, 숫자를 value로 갖는 HashMap
		ArrayList<String> order = new ArrayList<>();	//문자열 정렬을 위한 ArrayList
		for(int i=M; i<=N; i++) {	//M이상 N이하의 숫자만큼 실행
			int temp = i;		//임시 temp 변수에 i 복사
			if(temp >= 10) {	//temp가 10보다 클 경우(=두자릿수일 경우 / 숫자는 최대 두자릿 수)
				sb.append(stringNum[temp/10]+" ");	//10으로 나눈 몫에 해당하는 숫자를 읽은 문자열을 sb에 저장
				//sb.append(stringNum[temp/10]);
			}
			sb.append(stringNum[temp%10]);	//10으로 나눈 나머지에 해당하는 숫자를 읽은 문자열을 sb에 저장
			
			numMap.put(sb.toString(), i);	//HashMap에 Key, Value 값 저장
			order.add(sb.toString());		//ArrayList에 문자열 저장
			sb.setLength(0);				//다음 문자열을 위해 sb 초기화
		}

		Collections.sort(order);	//사전순 정렬
		
		int cnt = 0;	//10개씩 출력하기 위한 카운팅 변수
		for(String s: order) {	//order에 정렬된 문자열들 만큼 반복
			sb.append(numMap.get(s)+" ");	//sb에 문자열에 해당하는 숫자 저장
			cnt++;	//출력한 개수+1
			if(cnt == 10) {		//10개 카운팅이면 다음 줄
				sb.append("\n");	//sb에 줄바꿈 문자 저장
				cnt = 0;		//카운팅 초기화
			}
		}
		
		System.out.println(sb);		//결과 출력
	}
}
