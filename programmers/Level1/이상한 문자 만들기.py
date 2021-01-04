def solution(s):
    answer = ''
    i = 0
    for j in range(len(s)):
        if s[j] == " ":
            i = 0
            answer += " "
            continue
            
        if i%2 == 0:
            answer += s[j].upper()
        else:
            answer += s[j].lower()
        i += 1
                
    return answer
