def solution(s, n):
    s = list(s)
    for i in range(0, len(s)):
        if s[i].isupper():
            s[i] = chr((ord(s[i]) - ord('A') + n) % 26 + ord('A'))
        elif s[i].islower():
            s[i] = chr((ord(s[i]) - ord('a') + n) % 26 + ord('a'))
    return "".join(s)


#20210107_review
def solution(s, n):
    answer = ''
    for i in range(0, len(s)):
        if s[i].isupper():
            answer += chr((ord(s[i]) - ord('A') + n)%26 + ord('A'))
        elif s[i].islower():
            answer += chr((ord(s[i]) - ord('a') + n)%26 + ord('a'))
        else:
            answer += s[i]
    return answer
