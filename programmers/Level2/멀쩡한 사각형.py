#Summer/Winter Coding(2019)
from math import gcd

def solution(w,h):
    answer = 1
    maxpapers = w*h
    answer = maxpapers - (w+h-gcd(w, h))
    
    return answer
