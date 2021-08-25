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
