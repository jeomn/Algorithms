def solution(a, b):
    days  = b
    day = ['THU', 'FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED']
    months = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

    for i in range(0, a-1):
        days += months[i]
        
    answer = day[days%7]    
    return answer
