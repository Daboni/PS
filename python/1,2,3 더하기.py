#  dp(n) = dp(n-1)+dp(n-2)+dp(n-3)

T = int(input())
cache = [0 for _ in range(12)]

for i in range(T):
    n = int(input())
    cache[0:2] = [1,1]
    cache[3] = 2
    for j in range(2,n+1):
        cache[j] = cache[j-1] + cache[j-2] + cache[j-3]
    print(cache[n])
