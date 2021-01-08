#완전탐색
def solution(answers):
    answer, score = [], []
    stu_1, score_1 = [1, 2, 3, 4, 5], 0
    stu_2, score_2 = [2, 1, 2, 3, 2, 4, 2, 5], 0
    stu_3, score_3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5], 0
        
    for i in range(len(answers)):
        #1번 학생
        if answers[i] == stu_1[i % 5]:
            score_1 += 1
        #2번 학생
        if answers[i] == stu_2[i % 8]:
            score_2 += 1
        #3번 학생
        if answers[i] == stu_3[i % 10]:
            score_3 += 1
    
    score = [score_1, score_2, score_3]
    Max_score = max(score)

    for i in range(3):
        if Max_score == score[i]:
            answer.append(i+1)    
        
    return sorted(answer)
