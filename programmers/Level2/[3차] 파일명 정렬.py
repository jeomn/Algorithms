#2018 KAKAO BLIND RECRUITMENT
def solution(files):
    separate = []
    idx = 0
    for file in files:
        head, number, tail = '', '', ''
        for f in range(len(file)):
            if file[f].isdigit():
                number += file[f]
                if f != len(file)-1:
                    if not file[f+1].isdigit():
                        tail = file[f+1:]
            else:
                head += file[f].lower()
                    
            if len(tail) != 0 or f == len(file)-1:
                separate.append([idx, head, int(number), tail])
                break
        idx += 1

    separate.sort(key=lambda x: [x[1], x[2]])
    
    answer = []
    for item in separate:
        idx = item[0]
        answer.append(files[idx])
                
    return answer
