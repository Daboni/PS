from collections import deque

n,m,s = map(int,input().split())

a = [ [] for _ in range(n+1) ]

for i in range(m):
    x,y = map(int,input().split())
    a[x].append(y)
    a[y].append(x)

for i in range(n+1):
    a[i].sort()

check = [False]*(n+1)

def dfs(x):
    global check
    check[x] = True
    print(x,end=' ')
    for i in a[x]:
        if check[i] == False:
            dfs(i)


def bfs(start):
    check = [False]*(n+1)
    q = deque()
    q.append(start)
    check[start] = True
    while q:
        x = q.popleft()
        print(x,end=' ')
        for y in a[x]:
            if check[y] == False:
                check[y] = True
                q.append(y)

dfs(s)
print()
bfs(s)
print()
