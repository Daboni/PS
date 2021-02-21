n,m,k = map(int,input().split())

a = [list(map(int,input().split())) for _ in range(n)]
c = [[False]*m for _ in range(n)]
dx = [ 0, 0, 1, -1]
dy = [ 1, -1, 0, 0]

res = -1000000

def go(px,py,cnt,s):

    if cnt == k:
        global res
        if res < s:
            res = s
        return

    for x in range(px,n):
        for y in range(py if px == x else 0,m):
            if c[x][y]:
                continue
            ok = True
            for i in range(4):
                nx = x+dx[i]
                ny = y+dy[i]
                if 0 <= nx < n and 0 <= ny < m:
                    if c[nx][ny]:
                        ok = False
            if ok:
                c[x][y] = True
                go(x,y,cnt+1,s+a[x][y])
                c[x][y] = False

go(0, 0, 0, 0)
print(res)
