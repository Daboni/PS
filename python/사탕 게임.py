n = int(input())

a = [ list(input()) for _ in range(n) ]

ans = 0

def check(a):

    MAX= 1
    for i in range(n):
        cnt = 1
        ch = a[i][0]
        for j in range(1,n):
            if ch == a[i][j]:
                cnt += 1
            else:
                cnt = 1
                ch = a[i][j]
            if MAX < cnt:
                MAX = cnt

    for i in range(n):
        cnt = 1
        ch = a[0][i]
        for j in range(1,n):
            if ch == a[j][i]:
                cnt += 1
            else:
                cnt = 1
                ch = a[j][i]
            if MAX < cnt:
                MAX = cnt
                
    return MAX

    

for i in range(n):
    for j in range(n):

        if j+1<n:
            a[i][j],a[i][j+1] = a[i][j+1],a[i][j]
            cnt = check(a)
            if cnt > ans:
                ans = cnt

            a[i][j],a[i][j+1] = a[i][j+1],a[i][j]

        if i+1<n:
            a[i][j],a[i+1][j] = a[i+1][j],a[i][j]
            cnt = check(a)
            if  cnt> ans:
                ans = cnt

            a[i][j],a[i+1][j] = a[i+1][j],a[i][j]

print(ans)
