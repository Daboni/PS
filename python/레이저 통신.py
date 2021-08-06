from collections import deque

m,n = map(int,input().split())

a = [ list(input()) for _ in range(n) ]
d = [ [-1] * m for _ in range(n) ]

dx = [0,0,-1,1]
dy = [1,-1,0,0]

x1=y1=x2=y2=-1

for i in range(n):
    for j in range(m):
        if a[i][j] == 'C':
            if x1 == -1:
                x1 = i
                y1 = j
            else:
                x2 = i
                y2 = j

def bfs(x,y):

    q = deque()
    q.append((x,y))
    d[x][y] = 0
    
    while q:
        x,y = q.popleft()
        for k in range(4):
            nx,ny = x+dx[k] , y+dy[k]

            while 0<=nx<n and 0<=ny<m:
                if a[nx][ny] == '*':
                    break

                if d[nx][ny] == -1:
                    q.append((nx,ny))
                    d[nx][ny] = d[x][y] + 1

                nx += dx[k]
                ny += dy[k]

bfs(x1,y1)

print(d[x2][y2]-1)
