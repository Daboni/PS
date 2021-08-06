import sys

n = int(sys.stdin.readline().strip())
a = list(map(int,sys.stdin.readline().strip().split()))
k = int(sys.stdin.readline().strip())

d = [[0]*n for _ in range(n)]

for i in range(n):
    d[i][i] = True

for i in range(n-1):
    if a[i]==a[i+1]:
        d[i][i+1] = True

for l in range(3,n+1):
    for i in range(0, n-l+1):
        j = i+l-1
        if a[i] == a[j] and d[i+1][j-1]:
            d[i][j] = True

for i in range(k):
    x,y = map(int,sys.stdin.readline().strip().split())

    print(1 if d[x-1][y-1] else 0)
