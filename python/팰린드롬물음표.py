import sys

n = int(sys.stdin.readline().strip())
a = list(map(int,sys.stdin.readline().strip().split()))
k = int(sys.stdin.readline().strip())

d = [[-1]*n for _ in range(n) ]

def go(i,j):
    if i==j:
        return 1
    elif i+1 == j:
        if a[i] == a[j]:
            return 1
        else:
            return 0

    if d[i][j] != -1:
        return d[i][j]

    if a[i] != a[j]:
        d[i][j] = 0
    else:
        d[i][j] = go(i+1,j-1)

    return d[i][j]


for i in range(k):
    x,y = map(int,sys.stdin.readline().strip().split())

    print(go(x-1,y-1))
