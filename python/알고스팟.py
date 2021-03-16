from collections import deque

n,m = map(int,input().split())

a = [ list(map(int,list(input()))) for _ in range(m) ]

dx = [-1,0,1,0]
dy = [0,1,0,-1]

dist = [ [-1]*n for _ in range(m) ]

q = deque()
q.append((0,0))
dist[0][0]=0

while q:
    x,y = q.popleft()
    for k in range(4):
        nx,ny = x+dx[k], y+dy[k]
        if 0<=nx<m and 0<=ny<n:
            if dist[nx][ny] == -1:
                if a[nx][ny] == 0:
                    dist[nx][ny] = dist[x][y]
                    q.appendleft((nx,ny))
                else:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx,ny))

print(dist[m-1][n-1])
