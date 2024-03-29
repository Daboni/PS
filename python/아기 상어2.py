from collections import deque

dx = [1,1,0,-1,-1,-1,0,1]
dy = [0,1,1,1,0,-1,-1,-1]

n,m = map(int,input().split())

a = [ list(map(int,input().split())) for _ in range(n) ]

def bfs(sx,sy):
    d = [ [-1]*m for _ in range(n)]

    q = deque()
    q.append((sx,sy))
    d[sx][sy] = 0

    while q:
        x,y = q.popleft()
        for k in range(8):
            nx, ny = x+dx[k], y+dy[k]
            if 0 <= nx < n and 0<= ny < m:
                if d[nx][ny] == -1:
                    if a[nx][ny] == 1:
                        return d[x][y] + 1
                    else:
                        q.append((nx,ny))
                        d[nx][ny] = d[x][y] + 1
    return 0

ans = 0

for i in range(n):
    for j in range(m):
        if a[i][j] == 0:
            dist = bfs(i,j)
            if ans<dist:
                ans = dist

print(ans)
