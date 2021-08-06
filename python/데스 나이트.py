from collections import deque

n = int(input())

r1,c1,r2,c2 = map(int,input().split())

dx = [-2,-2,0,0,2,2]
dy = [-1,1,-2,2,-1,1]

dist = [ [-1]*n for _ in range(n) ]

q = deque()
q.append((r1,c1))

dist[r1][c1] = 0

while q:
    x,y=q.popleft()

    for k in range(6):
        nx, ny = x+dx[k], y+dy[k]
        if 0<= nx < n and 0<= ny < n:
            if dist[nx][ny] == -1:
                q.append((nx,ny))
                dist[nx][ny] = dist[x][y]+1

print(dist[r2][c2])
