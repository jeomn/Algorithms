def solution(seoul):
    for i in range(0, len(seoul)):
        if seoul[i] == 'Kim':
            return "김서방은 " + str(i) + "에 있다"

        
#20210106_review
def solution(seoul):        
    place = seoul.index("Kim")
    return "김서방은 " + str(place) + "에 있다"
