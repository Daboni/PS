n = int(input())

cache = [ [0]*4 for _ in range(1000001) ]

for i in range(1,1000001):

    if i-1 >= 0:
        cache[i][1] = cache[i-1][2] + cache[i-1][3]
        if i == 1:
            cache[i][1] = 1
    if i-2 >= 0:
        cache[i][2] = cache[i-2][1] + cache[i-2][3]
        if i == 2:
            cache[i][2] = 1
    if i-3 >= 0:
        cache[i][3] = cache[i-3][1] + cache[i-3][2]
        if i == 3:
            cache[i][3] = 1

    cache[i][1] %= 1000000009
    cache[i][2] %= 1000000009
    cache[i][3] %= 1000000009

for i in range(n):
    m = int(input())
    print(sum(cache[m])%1000000009)
