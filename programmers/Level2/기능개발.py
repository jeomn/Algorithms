#스택/큐
def solution(progresses, speeds):
    answer = []
    progresses_zip = list(zip(progresses, speeds))
    progresses_ing = [[progress, speed] for progress, speed in progresses_zip]

    while progresses_ing:
        external = 0
        day = 0
        #진도
        for i in range(len(progresses_ing)):
            progresses_ing[i][0] += progresses_ing[i][1]
        #진도율 확인
        for __ in range(len(progresses_ing)):
            if progresses_ing[0][0] >= 100:
                progresses_ing.pop(0)
                external += 1
            else:
                break
        if external > 0:
            answer.append(external)
      
    return answer
