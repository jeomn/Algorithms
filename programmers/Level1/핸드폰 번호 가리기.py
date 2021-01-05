def solution(phone_number):
    answer = ""
    for i in range(0, len(phone_number)-4):
        answer += "*"
    answer += phone_number[len(phone_number)-4:]
    return answer


#20210105_review
"""
def solution(phone_number):
    phone_number = list(phone_number)
    phone_number[:-4] = "*"*len(phone_number[:-4])
    return ''.join(phone_number)
"""
