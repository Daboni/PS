n,m = map(int,input().split())

a = [ list(input()) for i in range(n) ]

dx = [ 0,0,1,-1]
dy = [ 1,-1,0,0]

x1 = -1
y1 = -1
x2 = -1
y2 = -1

for i in range(n):
    for j in range(m):
        if a[i][j] == 'o':
            if x1 == -1:
                x1,y1 = i,j
            else:
                x2,y2 = i,j
            a[i][j] = '.'

def go(cnt,x1,y1,x2,y2):
    
    if cnt>10:
        return -1

    fall1 = False
    fall2 = False
    
    if (x1 < 0 or x1 >= n) or (y1 < 0 or y1 >= m):
        fall1 = True

    if (x2 < 0 or x2 >= n) or (y2 < 0 or y2 >= m):
        fall2 = True

    if fall1 and fall2:
        return -1
    if fall1 or fall2:
        return cnt

    ans = -1
    
    for k in range(4):
        nx1 = x1 + dx[k]
        ny1 = y1 + dy[k]
        nx2 = x2 + dx[k]
        ny2 = y2 + dy[k]
        if 0 <= nx1 < n and 0<= ny1 < m and a[nx1][ny1] == '#':
            nx1 = x1
            ny1 = y1
        if 0 <= nx2 < n and 0<= ny2 < m and a[nx2][ny2] == '#':
            nx2 = x2
            ny2 = y2

        temp = go(cnt+1,nx1,ny1,nx2,ny2)
        if temp == -1:
            continue
        if ans == -1 or ans>temp:
            ans = temp
    return ans

print(go(0,x1,y1,x2,y2))
