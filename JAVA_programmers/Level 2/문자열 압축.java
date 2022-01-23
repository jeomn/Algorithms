//20210825
//2021 KAKAO BLIND RECRUITMENT


class Solution {
    public int solution(String s) {
        int answer = 0;
        int minLength = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        if(s.length() == 1) return 1;
        
        for(int i=1; i<(s.length()/2+1); i++){
            String substr = s.substring(0, i);
            int num = 1, idx = 0;
            
            for(int j=i; j<s.length(); j+=i){    //문자열 비교(j글자씩 반복)
                idx = j+i;
                if(idx > s.length()){
                    substr = s.substring(j-i, s.length());
                    break;
                }
                String temp = s.substring(j, idx);
                if(substr.equals(temp)){
                    num++;
                }else{
                    if(num == 1)
                        sb.append(substr);
                    else
                        sb.append(num+substr);
                    num = 1;
                    idx = j+i;
                    substr = temp;
                }
            }
            if(num == 1)
                sb.append(substr);
            else
                sb.append(num+substr);

            minLength = Math.min(minLength, sb.length());
            sb.setLength(0);
            
        }
        answer = minLength;
        return answer;
    }
}




//20220124
//2021 KAKAO BLIND RECRUITMENT

import java.util.*;


class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        StringBuilder sb = new StringBuilder();
        for(int l=1; l<(s.length()/2)+1; l++){
            int cnt=0;
            String subStr = s.substring(0, l);
            for(int i=0; i<s.length(); i+=l){
                if(i+l > s.length()){
                    subStr = s.substring(i-l, s.length());
                    break;
                }
                
                String temp = s.substring(i, i+l);
                if(subStr.equals(temp)){
                    cnt++;
                }else{
                    if(cnt==1){
                        sb.append(subStr);
                    }else{
                        sb.append(cnt+subStr);
                    }
                    subStr = temp;
                    cnt=1;
                }
            }
            if(cnt==1) sb.append(subStr);
            else sb.append(subStr+cnt);
            answer = Math.min(answer, sb.length());
            sb.setLength(0);
        }
        
        return answer;
    }
}
