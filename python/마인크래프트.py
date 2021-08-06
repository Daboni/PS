from collections import deque

n,m,b = map(int,input().split())

a = [ list(map(int,input().split())) for _ in range(n) ]

dx = [0,0,1,-1]
dy = [1,-1,0,0]

group = []

group_size = []

d = [[-1]*m for _ in range(n)]

def bfs(sx,sy):

    group_num = len(group_size)
    cnt = 1
    q = deque()
    q.append((sx,sy))
    d[sx][sy] = group_num
    group.append(a[sx][sy])
    while q:
        x,y = q.popleft()
        for k in range(4):
            nx,ny = x+dx[k], y+dy[k]

            if 0<=nx<n and 0<=ny<m:
                if a[x][y] == a[nx][ny] and d[nx][ny] == -1:
                    q.append((nx,ny))
                    d[nx][ny] = group_num
                    cnt += 1

    
    group_size.append(cnt)

for i in range(n):
    for j in range(m):
        if d[i][j] == -1:
            bfs(i,j)

MAX = max(group)
MIN = min(group)
ans_time = 1e9
ans_height = -1e9

for i in range(MIN,MAX+1):
    blocks = b
    time = 0
    height = i
    for j in range(len(group_size)):
        if group[j] == i:
            continue

        if i > group[j]:
            time+=(i-group[j])*group_size[j]
            blocks -= (i-group[j])*group_size[j]

        else:
            time += 2*(group[j]-i)*group_size[j]
            blocks += (group[j]-i)*group_size[j]

    if blocks < 0:
        continue

    if ans_time >= time:
        if ans_time == time:
           if ans_height < height:
                ans_time = time
                ans_height = height
        else:
            ans_time = time
            ans_height = height

print(ans_time,ans_height)
