#2018 KAKAO BLIND RECRUITMENT
import datetime

def solution(m, musicinfos):
    played_list = []
    order = 0
    for music in musicinfos:
        start, end, name, melody = music.split(',')
        start_time = datetime.datetime.strptime(start, "%H:%M")
        end_time = datetime.datetime.strptime(end, "%H:%M")
        play_time = (end_time-start_time).seconds//60
        
        melody_list = list(melody)
        for idx in range(len(melody)):
            if not melody_list[idx].isalpha():
                melody_list[idx-1] = melody_list[idx-1]+melody_list[idx]
                melody_list[idx] = ''
        while '' in melody_list:
            melody_list.remove('')
        
        playCnt, playPart = divmod(play_time, len(melody_list))
        play = melody_list*(playCnt) + melody_list[0:playPart]
        played_list.append([order, name, play])
        order += 1
    
    search_melody = list(m)
    for idx in range(len(m)):
        if not search_melody[idx].isalpha():
            search_melody[idx-1] = search_melody[idx-1]+search_melody[idx]
            search_melody[idx] = ''
    while '' in search_melody:
        search_melody.remove('')
    
    answer_list = []
    for p in sorted(played_list, key=lambda x: len(x[2])):
        for idx in range(len(p[2])):
            if search_melody[0] == p[2][idx]:
                if search_melody == p[2][idx:idx+len(search_melody)]:
                    answer_list.append(p)
                    break
    
    if len(answer_list) == 1:
        answer = answer_list[0][1]
    elif len(answer_list) == 0:
        answer = '(None)'
    else:
        maxTime, index = -1, -1
        for a in answer_list:
            if maxTime < len(a[2]):
                maxTime = len(a[2])
                index = a[0]
                answer = a[1]
            elif maxTime == len(a[2]):
                if index > a[0]:
                    index = a[0]
                    answer = a[1]

    return answer
