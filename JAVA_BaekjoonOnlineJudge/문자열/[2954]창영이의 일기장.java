import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{	//실행을 위한 main 함수. 입출력 처리를 위해 throws Exception
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//문장을 입력받기 위한 BufferedReader 선언
		
		String input = br.readLine();	//문장 입력받아 input에 저장
		
		int skip = 0;	//skip할 횟수
		StringBuilder sb = new StringBuilder();	//원래의 문장을 저장할 StringBuilder 선언
		for(int idx=0; idx<input.length(); idx++) {		//input 크기만큼 반복
			if(skip != 0) {	//skip해야 할 횟수가 있을 경우
				skip--;		//skip 횟수 차감
				continue;	//skip: continue로 반복문 지나감
			}
			
			char s = input.charAt(idx);		//input의 idx인덱스 글자를 charater타입 s에 저장
			if(s == 'a' || s == 'e' || s=='i' || s=='o' || s=='u') {	//s가 문제에서 주어진 모음(a, e, i, o, u)일 경우
				skip = 2;	//skip 횟수 두 번(p, 모음) 설정
			}
			
			sb.append(s);	//sb에 글자 저장
		}
		System.out.println(sb);	//원래의 문장 출력
	}
}
