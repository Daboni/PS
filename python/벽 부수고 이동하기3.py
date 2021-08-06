from collections import deque
import sys

n,m,l = map(int,sys.stdin.readline().split())

a = [ list(sys.stdin.readline()) for _ in range(n) ]

#d = [ [[0]*11 for _ in range(m) ] for _ in range(n) ]
d = [[[[0]*2 for k in range(11)] for i in range(m)] for j in range(n)]
dx = [0,0,-1,1]
dy = [1,-1,0,0]

q = deque()
d[0][0][0][0] = 1

q.append((0,0,0,0))

MIN = 1e9
while q:

    x,y,z,noon = q.popleft()

    if x == n-1 and y == m-1:
        MIN = min(MIN,d[x][y][z][noon])
    for k in range(4):
        nx,ny = x+dx[k],y+dy[k]

        if 0 <= nx < n and 0<= ny < m:
            if d[nx][ny][z][1-noon] == 0 and a[nx][ny] == '0':
                d[nx][ny][z][1-noon] = d[x][y][z][noon] + 1
                q.append((nx,ny,z,1-noon))

            elif a[nx][ny] == '1' and z<l and d[nx][ny][z+1][1-noon] == 0 and noon == 0:
                d[nx][ny][z+1][1-noon] = d[x][y][z][noon] + 1
                q.append((nx,ny,z+1,1-noon))
    if d[x][y][z][1-noon] == 0:
        d[x][y][z][1-noon] = d[x][y][z][noon]+1
        q.append((x,y,z,1-noon))
        

print(MIN if MIN != 1e9 else -1)
