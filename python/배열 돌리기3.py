m,n,r = map(int,input().split())

a = [ list(map(int,input().split())) for _ in range(m) ]

ops = list(map(int,input().split()))

def func1(a):
    m = len(a)
    n = len(a[0])
    for i in range(m//2):
        a[i],a[m-i-1] = a[m-i-1],a[i]
    return a

def func2(a):
    m = len(a)
    n = len(a[0])    
    for i in range(m):
        for j in range(n//2):
            a[i][j],a[i][n-j-1] = a[i][n-j-1],a[i][j]
    return a


def func3(a):
    m = len(a)
    n = len(a[0])
    b = [ [0] * m for _ in range(n) ]
    for i in range(n):
        for j in range(m):
            b[i][j] = a[m-j-1][i]
            # 1 1 -> 6 1,  1 2 -> 5 1, 1 3 -> 4 1
            # 2 1 -> 6 2,  2 2 -> 5 2, 2 3 -> 4 2
            # 3 1 -> 6 3,  3 2 -> 5 3, 2 3 -> 4 3
    return b

def func4(a):
    m = len(a)
    n = len(a[0])
    b = [ [0] * m for _ in range(n) ]
    for i in range(n):
        for j in range(m):
            b[i][j] = a[j][n-i-1]
            # 1 1 -> 1 6, 1 2 -> 2 6, 1 3 -> 3 6
            # 2 1 -> 1 5  2 2 -> 2 5, 2 3 -> 3 5
    return b

def func5(a):
    m = len(a)
    n = len(a[0])
    b = [ [0] * n for _ in range(m) ]
    bx = m//2
    by = n//2
    for i in range(m):
        for j in range(n):
            if i < bx and j < by:
                b[i][j+by] = a[i][j]
            elif i < bx and j >= by:
                b[i+bx][j] = a[i][j]
            elif i >= bx and j >= by:
                b[i][j-by] = a[i][j]
            elif i >= bx and j < by:
                b[i-bx][j] = a[i][j]
    return b

def func6(a):
    m = len(a)
    n = len(a[0])
    b = [ [0] * n for _ in range(m) ]
    bx = m//2
    by = n//2
    for i in range(m):
        for j in range(n):
            if i < bx and j < by:
                b[i+bx][j] = a[i][j]
            elif i < bx and j >= by:
                b[i][j-by] = a[i][j]
            elif i >= bx and j >= by:
                b[i-bx][j] = a[i][j]
            elif i >= bx and j < by:
                b[i][j+by] = a[i][j]
    return b

for op in ops:
    if op == 1:
        a=func1(a)
    if op == 2:
        a=func2(a)
    if op == 3:
        a=func3(a)
    if op == 4:
        a=func4(a)
    if op == 5:
        a=func5(a)
    if op == 6:
        a=func6(a)

for row in a:
    print(*row, sep = ' ')
