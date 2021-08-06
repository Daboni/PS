from collections import deque

limit = 1e10

n,m = map(int,input().split())
check = set()
q = deque()
q.append((n,''))
check.add(n)

while q:
    x,s = q.popleft()

    if x == m:
        if len(s) == 0:
            s = '0'
        print(s)
        exit()

    if 0<=x*x<=limit and x*x not in check:
        q.append((x*x,s+'*'))
        check.add(x*x)
    if 0<=x+x<=limit and x+x not in check:
        q.append((x+x,s+'+'))
        check.add(x+x)
    if 0<=x-x<=limit and x-x not in check:
        q.append((x+x,s+'+'))
        check.add(x-x)
    if x != 0 and 0<= x//x <= limit and x//x not in check:
        q.append((x//x,s+'/'))
        check.add(x//x)

print(-1)
