from collections import deque

m,n = map(int,input().split())

a = [ list(map(int,input().split())) for _ in range(n) ]

dx = [0,0,-1,1]
dy = [1,-1,0,0]

istomate = []

for i in range(n):
    for j in range(m):
        if a[i][j] == 1:
            istomato.append((i,j))


def bfs(sx,sy):
    q = deque()
    d = [ [-1]*m for _ in range(n) ]

    q.append((sx,sy))
    d[sx][sy] = 0

    while q:
        x,y = q.popleft()

        for k in range(4):
            nx,ny = x+dx[k], y+dy[k]

            if 0<=nx<n and 0<=ny<m and d[nx][ny] == -1:
                if a[nx][ny] == 0:
                    q.append((nx,ny))
                    d[nx][ny] == d[nx][ny] + 1

    return d

for i in range(len(istomato)):
    
