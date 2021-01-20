#2019 카카오 개발자 겨울 인
def solution(s):
    answer = []
    s_str = s[1:-1].replace("},", "}/")
    s_list = s_str.split("/")
    s_list = list(map(lambda x: x[1:len(x)-1], s_list))
    s_list = list(map(lambda x: x.split(','), s_list))
    
    s_list = sorted(s_list, key=lambda x: len(x))
    
    for s_temp in s_list:
        for s_item in s_temp:
            s_item = int(s_item)
            if s_item not in answer:
                answer.append(s_item)
    
    return answer
