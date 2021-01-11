# 삼각형 위의 최대 경로
"""
문제
삼각형으로 배치된 자연수들이 있다. 맨위에 숫자에서 시작해서, 한 번에 한 칸씩 아래로 내려가 맨 아래 줄까지 닿는 경로를 만들려고 한다.
경로는 아래줄로 내려갈 때 마다 바로 아래 숫자 혹은 오른쪽 아래 숫자로 내려갈 수 있다. 이때 모든 경로 중 숫자의 합을 최대화하는 경로를 구하여라
"""

a = [[1],[1,2],[3,7,4],[9,4,1,7],[2,7,5,9,4]]

cache = [[0 for _ in range(5)] for __ in range(5)]

# dp(y,x) = max(dp(y+1,x) dp(y,x+1)) + sum

def dp(y,x):
    if y == 4 :
        return a[y][x]
    if cache[y][x] != 0:
        return cache[y][x]
    cache[y][x] = a[y][x] + max(dp(y+1,x),dp(y+1,x+1))
    return cache[y][x]

