n = int(input())

a = [ list(map(int,input().split())) for _ in range(n) ]

cache = [ [0]*n for _ in range(n) ]

cache[0][0] = a[0][0]

for i in range(1,n):
    for j in range(i+1):
        if j == 0:
            cache[i][j] = cache[i-1][j]+a[i][j]
        else:
            cache[i][j] = max(cache[i-1][j-1]+a[i][j], cache[i-1][j]+a[i][j])

print(max(cache[n-1]))
