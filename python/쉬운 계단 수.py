N = int(input())

cache = [[ 0 for i in range(10) ] for j in range(N+1)]

for i in range(1,10):
    cache[1][i] = 1

for i in range(2,N+1):
    for j in range(10):
        if j == 0:
            cache[i][j]  = cache[i-1][j+1]
        elif j == 9:
            cache[i][j] = cache[i-1][j-1]
        else:
            cache[i][j] = cache[i-1][j-1]+cache[i-1][j+1]

print(sum(cache[N])%1000000000)
