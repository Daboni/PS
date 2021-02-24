T = int(input())

for _ in range(T):
    m,n,x,y = map(int,input().split())

    x-= 1; y-=1

    year = x
    ok = 0
    while True:
        if year >= n*m:
            break
        
        if year % n == y:
            ok = 1
            break

        year += m

    if ok == 1:
        print(year+1)
    else:
        print(-1)
