# 동적 계획법 - 이항계수
"""
문제
동적 계획법을 이용하여 이항 계수를 구현한다.
"""

cache = [[0 for _ in range(30)] for __ in range(30)]

def bino(n,r):
    if r == 0 or n == r:
        return 1
    if cache[n][r] != 0:
        return cache[n][r]

    cache[n][r] = bino(n-1,r-1)+bino(n-1,r)
    return cache[n][r]

a = bino(4,2)
