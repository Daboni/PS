# dp(i,j) = max(dp(i+1,j+1),,dp(i+1,j))

n = int(input())

a = []

for i in range(n):
    b = list(map(int,input().split()))
    a.append(b)


cache = [[0 for _ in range(n)] for __ in range(n)]

def dp(i,j):
    if i == n-1:
        return a[i][j]

    if cache[i][j] != 0:
        return cache[i][j]

    if j == 0:
        cache[i][j] = a[i][j]+max(dp(i+1,j+1),dp(i+1,j))
    else :
        cache[i][j] = a[i][j]+max(dp(i+1,j),dp(i+1,j+1))

    return cache[i][j]

print(dp(0,0))
