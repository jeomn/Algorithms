2021 KAKAO BLIND RECRUITMENT


class Solution {
    public String solution(String new_id) {
        String temp = new_id;
		temp = temp.toLowerCase();
		temp = temp.replaceAll("[~!@#$%^&*\\(\\)=+\\[\\{\\]\\}:?,<>/]", "");
		temp = temp.replaceAll("[\\.]{2,}", ".");
		temp = temp.replaceAll("^\\.|\\.$", "");
		
		if(temp.length() == 0) {
			temp = "a";
		}
		if(temp.length() >= 16) {
			temp = temp.substring(0, 15).replaceAll("\\.$", "");
		}
		if(temp.length() <= 2) {
			int length = temp.length();
			while(length != 3) {
				temp += temp.substring(temp.length()-1);
				length++;
			}
		}
		
		return temp;
    }
}
