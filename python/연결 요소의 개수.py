from collections import deque

n,m = map(int,input().split())

a = [ [] for _ in range(n+1) ]

for i in range(m):
    x,y = map(int,input().split())
    a[x].append(y)
    a[y].append(x)

ans = 0

check = [ False ] *(n+1)

def bfs(start):
    check    
    q = deque()
    q.append(start)
    check[start] = True
    while q:
        x =  q.popleft()
        for y in a[x]:
            if check[y] == False:
                check[y] = True
                q.append(y)

for i in range(1,n+1):
    if not check[i]:
        bfs(i)
        ans += 1

print(ans)
