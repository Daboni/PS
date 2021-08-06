# d[i] = d[i-1][0] + d[i-1][1]

n = int(input())

cache = [ [0]*3 for i in range(n+1) ]

cache[0][0] = 1

for i in range(1,n+1):

    cache[i][0] = cache[i-1][0] + cache[i-1][1] + cache[i-1][2]
    cache[i][1] = cache[i-1][0] + cache[i-1][2]
    cache[i][2] = cache[i-1][0] + cache[i-1][1]

    for j in range(3):
        cache[i][j] %= 9901

print(sum(cache[n])%9901)
