# d[k][n] = ㄷd[k-1][n-l]

n,k = map(int,input().split())

mod = 1000000000
cache = [ [0]*(n+1) for _ in range(k+1) ]
cache[0][0] = 1

for i in range(1,k+1):
    for j in range(n+1):
        for l in range(j+1):
            cache[i][j] += cache[i-1][j-l]
        cache[i][j] %= mod

print(cache[-1][-1])
