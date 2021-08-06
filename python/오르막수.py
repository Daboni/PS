n = int(input())
mod = 10007
cache = [ [0]*10 for _ in range(1001)]

for i in range(10):
    cache[1][i] = 1

for i in range(2,n+1):
    for j in range(10):
        for k in range(j+1):
            cache[i][j] += cache[i-1][k]
            cache[i][j] %= mod

ans = sum(cache[n])
print(ans%mod)
