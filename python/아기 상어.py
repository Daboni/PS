from collections import deque

n = int(input())

a = [ list(map(int,input().split())) for _ in range(n) ]

dx = [0,0,-1,1]
dy = [1,-1,0,0]

x = 0
y = 0

for i in range(n):
    for j in range(n):
        if a[i][j] == 9:
            a[i][j] = 0
            x,y = i,j

ans = 0
size = 2
exp = 0

def bfs(a,x,y,size):
    n = len(a)
    ans = []
    d = [ [-1]*n for _ in range(n)]
    q = deque()
    q.append((x,y))
    d[x][y] = 0
    while q:
        x,y = q.popleft()
        for k in range(4):
            nx,ny = x+dx[k],y+dy[k]

            if 0 <= nx < n and 0 <= ny < n and d[nx][ny] == -1:
                ok = False
                eat = False

                if a[nx][ny] == 0:
                    ok = True

                elif a[nx][ny] < size:
                    ok = True
                    eat = True

                elif a[nx][ny] == size:
                    ok = True

                if ok:
                    q.append((nx,ny))
                    d[nx][ny] = d[x][y] + 1
                    if eat:
                        ans.append((d[nx][ny],nx,ny))

    if not ans:
        return None
    ans.sort()
    return ans[0]

while True:
    p = bfs(a,x,y,size)
    if p is None:
        break

    dist,nx,ny = p
    a[nx][ny] = 0
    ans += dist
    exp += 1
    if size == exp:
        size += 1
        exp = 0
    x,y = nx,ny

print(ans)
