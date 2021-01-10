#해시
def solution(phone_book):
    answer = True
    sort = sorted(phone_book, key=len)
    
    for i in range(len(sort)):
        num = sort[i]
        compare_nums = sort.copy()
        compare_nums.remove((num))
        """
        print(num, compare_nums)
        if num in compare_nums:
            answer = False
            break
        """
        for j in range(len(compare_nums)):
            if num in compare_nums[j][:len(num)]:
                answer = False
                return False
    return answer
