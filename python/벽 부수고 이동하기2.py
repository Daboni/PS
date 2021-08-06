from collections import deque

n,m,l = map(int,input().split())

a = [ list(map(int,list(input()))) for _ in range(n) ]

d = [ [[0]*11 for _ in range(m)] for _ in range(n) ]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

q = deque()
d[0][0][0] = 1

q.append((0,0,0))

while q:
    x,y,z = q.popleft()

    for k in range(4):
        nx,ny = x+dx[k], y+dy[k]

        if 0 <= nx < n and 0 <= ny < m:
            if a[nx][ny] == 0 and d[nx][ny][z] == 0:
                d[nx][ny][z] = d[x][y][z] + 1
                q.append((nx,ny,z))
            elif a[nx][ny] == 1 and z<l and d[nx][ny][z+1] == 0:
                d[nx][ny][z+1] = d[x][y][z] + 1
                q.append((nx,ny,z+1))

ans = -1

for i in range(l+1):
    if d[n-1][m-1][i] == 0 :
        continue
    if ans == -1:
        ans = d[n-1][m-1][i]
    else:
        ans = min(ans,d[n-1][m-1][i])
        
print(ans)
