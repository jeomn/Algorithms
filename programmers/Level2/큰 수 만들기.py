#탐욕법(Greedy)
def solution(number, k):
    arrange_nums = [number[0]]
    
    for i in range(1, len(number)):
        while len(arrange_nums) != 0 and arrange_nums[-1] < number[i] and k > 0:
            arrange_nums.pop()
            k -= 1
        if k == 0:
            arrange_nums += number[i:]
            break
        arrange_nums.append(number[i])
    
    if k > 0:
        arrange_nums = arrange_nums[:-k]
        
    answer = ''.join(arrange_nums)
    return answer
