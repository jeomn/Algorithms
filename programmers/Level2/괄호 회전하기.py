#20210429
#월간 코드 챌린지 시즌2

from collections import deque

def solution(s):
    answer = 0
    
    deque_s = deque(s)
    for _ in range(len(s)):
        deque_s.rotate(-1)
        
        stack, flag = [0], True
        for idx in range(len(s)):
            if deque_s[idx] in ('(', '{', '['):
                stack.append(deque_s[idx])
            elif deque_s[idx] == ')':
                if stack[-1] == '(':
                    stack.pop()
                else:
                    flag = False
                    break
            elif deque_s[idx] == '}':
                if stack[-1] == '{':
                    stack.pop()
                else:
                    flag = False
                    break
            elif deque_s[idx] == ']':
                if stack[-1] == '[':
                    stack.pop()
                else:
                    flag = False
                    break
            else:
                continue
        
        if len(stack) > 1:
            flag = False        
        
        if flag:
            answer += 1
    
    return answer
