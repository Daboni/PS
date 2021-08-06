def go(index,cal,man):

    global ans
    
    if cal > l:
        return

    if index == n:
        ans = max(ans,man)
        return

    go(index+1, cal+ki[index], man+ti[index])
    go(index+1, cal, man)


t = int(input())

for tc in range(1,t+1):

    n,l = map(int,input().split())

    ans = 0
    ti = []
    ki = []
    
    for i in range(n):
        a,b = map(int,input().split())
        ti.append(a)
        ki.append(b)
        
    go(0,0,0)
    
    print('#{} {}'.format(tc,ans))
