n = int(input())

a = list(map(int,input().split()))

res = [ 0 for _ in range(n)]

for i in range(1,n+1):
    m = a[i-1]
    cnt = 0
    for j in range(n):
        if cnt == m and res[j] == 0:
            res[j] = i
            break
        elif res[j] == 0:
            cnt += 1

for _ in res:
    print(_, end = ' ')
