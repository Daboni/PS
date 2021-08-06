cache = [ [0 for _ in range(11)] for __ in range(11) ]

def bino(n,r):
    if r == 0 or n == r:
        return 1
    if cache[n][r] != 0:
        return cache[n][r]
    cache[n][r] = bino(n-1,r-1)+bino(n-1,r)
    return cache[n][r]

n,k = map(int,input().split())

print(bino(n,k))
