from collections import deque

n,m = map(int,input().split())

a = [ list(input()) for _ in range(n) ]

visited = [[[[-1] * m for _ in range(n)] for _ in range(m)] for _ in range(n) ]
    
# 1. 이동 dir

dx = [1,-1,0,0]
dy = [0,0,1,-1]

for i in range(n):
    for j in range(m):
        if a[i][j] == 'B':
            b = (i,j)
            a[i][j] = '.'
        elif a[i][j] == 'R':
            r = (i,j)
            a[i][j] = '.'

def move(x,y,dx,dy):
    l = 0
    while a[x+dx][y+dy] != '#' and a[x][y] != 'O':
        x += dx
        y += dy
        l += 1
    return x,y,l

def bfs():
    visited[b[0]][b[1]][r[0]][r[1]] = 0
    q = deque()
    q.append((b[0],b[1],r[0],r[1]))
    
    while q:
        bx,by,rx,ry = q.popleft()
        if visited[bx][by][rx][ry] >= 10:
            break
        for i in range(4):
            nbx,nby,b_count = move(bx,by,dx[i],dy[i])
            nrx,nry,r_count = move(rx,ry,dx[i],dy[i])

            if a[nbx][nby] == 'O':
                continue
            if a[nrx][nry] == 'O':
                print(visited[bx][by][rx][ry]+1)
                return
            if nbx==nrx and nby == nry:
                if b_count > r_count:
                    nbx -= dx[i]
                    nby -= dy[i]
                else:
                    nrx -= dx[i]
                    nry -= dy[i]
            if visited[nbx][nby][nrx][nry] == -1:
                visited[nbx][nby][nrx][nry] = visited[bx][by][rx][ry] + 1
                q.append((nbx,nby,nrx,nry))
    print(-1)

bfs()
