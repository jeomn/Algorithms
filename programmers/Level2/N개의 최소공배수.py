from math import gcd

def lcm(a, b):
    return a*b//gcd(a, b)
    
def solution(arr):
    while len(arr) >= 2:
        arr.append(lcm(arr.pop(), arr.pop()))
        
    answer = arr[0]
    return answer
