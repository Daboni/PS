from collections import deque

dx = [0,0,-1,1]
dy = [1,-1,0,0]

t = int(input())

def bfs(a,x,y):

    n = len(a)
    m = len(a[0])
    dist = [ [-1]*m for _ in range(n) ]

    q = deque()
    q.append((x,y))
    dist[x][y] = 0

    while q:
        x,y = q.popleft()
        for k in range(4):
            nx,ny = x+dx[k], y+dy[k]
            if 0<=nx<n and 0<=ny<m and a[nx][ny] != '*' and dist[nx][ny] == -1:
                if a[nx][ny] == '#':
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx,ny))
                else:
                    dist[nx][ny] = dist[x][y]
                    q.appendleft((nx,ny))
    return dist


while t:
    n,m = map(int,input().split())

    a = [ '.'*(m+2) ]
    for i in range(n):
        a.append('.'+input()+'.')
    a.append('.'*(m+2))

    d0 = bfs(a,0,0)
    x1=y1=x2=y2=-1
    for i in range(n+2):
        for j in range(m+2):
            if a[i][j] == '$':
                if x1 == -1:
                    x1 = i
                    y1 = j
                else:
                    x2 = i
                    y2 = j
    d1 = bfs(a,x1,y1)
    d2 = bfs(a,x2,y2)

    ans = 1e9

    for i in range(n+2):
        for j in range(m+2):
            if a[i][j] == '*':
                continue
            if d0[i][j] == -1 or d1[i][j] == -1 or d1[i][j] == -1:
                continue
            cur = d0[i][j] + d1[i][j] + d2[i][j]
            if a[i][j] == '#':
                cur -= 2
            ans = min(ans,cur)

    print(ans)
    t-=1
