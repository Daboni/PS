n = int(input())

t = [0]*(n+1)
p = [0]*(n+1)

for i in range(n):
    t[i],p[i] = map(int,input().split())

ans = 0

def go(day,s):

    global ans

    if day == n+1:
        if ans < s:
            ans = s
        return
        
    if day > n+1:
        return

    go(day+1,s)
    go(day+t[day],s+p[day])
    

go(1,0)
print(ans)
