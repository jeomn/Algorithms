class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String s:skill_trees){
            boolean flag = true;
            boolean[] check = new boolean[skill.length()];
            for(int i=0; i<s.length(); i++){
                char tempS = s.charAt(i);
                int searchIdx = skill.indexOf(tempS);
                if(searchIdx == -1) continue;
                if(searchIdx != 0 && !check[searchIdx-1]){
                    flag = false;
                    break;
                }
                else check[searchIdx] = true;
            }
            if(flag) answer++;
        }
        
        return answer;
    }
}
