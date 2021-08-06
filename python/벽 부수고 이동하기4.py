from collections import deque

n,m = map(int,input().split())

a = [ list(map(int,list(input()))) for _ in range(n) ]

group = [ [-1]*m for _ in range(n) ]
check = [ [False] * m for _ in range(n) ]
group_size = []

dx = [ 0, 0, -1, 1 ]
dy = [ 1, -1, 0, 0 ]

def dfs(sx,sy):

    g = len(group_size)    
    q = deque()
    q.append((sx,sy))
    group[sx][sy] = g
    check[sx][sy] = True
    cnt = 1
    while q:
        x,y = q.popleft()

        for k in range(4):
            nx = x+dx[k]
            ny = y+dy[k]
            if 0 <= nx < n and 0<= ny < m:
                if check[nx][ny] == False and a[nx][ny] == 0:
                    q.append((nx,ny))
                    group[nx][ny] = g
                    check[nx][ny] = True
                    cnt += 1
    
    group_size.append(cnt)

for i in range(n):
    for j in range(m):
        if a[i][j] == 0 and check[i][j] == False:
            dfs(i,j)

for i in range(n):
    for j in range(m):
        if a[i][j] == 0:
            print(0,end = ' ')
        else:
            cnt = 1
            tmp = []
            for k in range(4):
                nx = i+dx[k]
                ny = j+dy[k]
                if 0 <= nx < n and 0 <= ny < m:
                    if a[nx][ny] == 0:
                        tmp.append(group[nx][ny])
            tmp = set(tmp)
            for group_num in tmp:
                cnt += group_size[group_num]
            print(cnt%10,end=' ')
    print()
