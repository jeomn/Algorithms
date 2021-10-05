class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        
        for(int r=3; r<=total; r++){
            if(total%r != 0) continue;
            int c = total/r;
            
            int cb = (2*r)+(2*(c-2));
            int cy = (r-2)*(c-2);
            if(cb==brown && cy==yellow){
                answer[0] = r;
                answer[1] = c;
            }
        }        
        return answer;
    }
}
