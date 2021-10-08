//위클리 챌린지
//20211008

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        
        int stuNum = scores.length;
        for(int i=0; i<stuNum; i++){
            int myScore = scores[i][i];
            
            int min = myScore;
            int max = myScore;
            boolean isUnique = true;
            
            int sumScore = myScore;
            for(int j=0; j<stuNum; j++){
                if(i==j) continue;
                int otherScore = scores[j][i];
                sumScore += otherScore;
                
                if(otherScore == myScore) isUnique = false;
                min = Math.min(min, otherScore);
                max = Math.max(max, otherScore);
            }
            if(isUnique && (myScore==min || myScore==max)){
                answer += getGrade((sumScore-myScore)/(stuNum-1));
            } else{
                answer += getGrade(sumScore/stuNum);
            } 
        }
        
        return answer;
    }
    
    public String getGrade(int score){
        if(score < 50) return "F";
        else if(score < 70) return "D";
        else if(score < 80) return "C";
        else if(score < 90) return "B";
        else return "A";
    }
}
