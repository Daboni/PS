n,s = map(int,input().split())

a = list(map(int,input().split()))

ans = 0

def go(index,Sum):

    global ans
    if index == n:
        if Sum == s:
            ans += 1
        return

    go(index+1,Sum+a[index])
    go(index+1,Sum)


go(0,0)
if s == 0:
    ans -= 1

print(ans)
