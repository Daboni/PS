from collections import deque

n = int(input())

a = [ list(input()) for _ in range(n) ]

a2= [ ['R']*n for _ in range(n) ]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

for i in range(n):
    for j in range(n):
        if a[i][j] == 'B':
            a2[i][j] = 'B'


def bfs(a,sx,sy):

    
    q = deque()
    q.append((sx,sy))

    check[sx][sy] = True

    while q:
        x,y = q.popleft()

        for k in range(4):
            nx , ny = x+dx[k], y+dy[k]

            if 0 <= nx < n and 0<=ny<n and check[nx][ny] == False:
                if a[x][y] == a[nx][ny]:
                    q.append((nx,ny))
                    check[nx][ny] = True

ans1 = 0
ans2 = 0

check = [ [False] * n for _ in range(n) ]
for i in range(n):
    for j in range(n):
        if check[i][j] == False:
            bfs(a,i,j)
            ans1 += 1
check = [ [False] * n for _ in range(n) ]
for i in range(n):
    for j in range(n):
        if check[i][j] == False:
            bfs(a2,i,j)
            ans2 += 1

print(ans1,ans2)
