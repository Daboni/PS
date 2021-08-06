from collections import deque

n = int(input())

board = [ list(map(int,input().split())) for _ in range(n) ]

q = deque()

MAX = -1e9

def get(i,j):
    if board[i][j]:
        q.append(board[i][j])
        board[i][j] = 0


def merge(i,j,dx,dy):
    while q:
        x = q.popleft()
        if not board[i][j]:
            board[i][j] = x
        elif board[i][j] == x:
            board[i][j] = x*2
            i,j = i+dx,j+dy
        else:
            i,j = i+dx,j+dy
            board[i][j] = x
        
def move(dirs):
    #위
    if dirs == 0:
        for j in range(n):
            for i in range(n):
                get(i,j)
            merge(0,j,1,0)
    #아래
    elif dirs == 1:
        for j in range(n):
            for i in range(n-1,-1,-1):
                get(i,j)
            merge(n-1,j,-1,0)
    #오
    elif dirs == 2:
        for i in range(n):
            for j in range(n-1,-1,-1):
                get(i,j)
            merge(i,n-1,0,-1)
    #왼
    elif dirs == 3:
        for i in range(n):
            for j in range(n):
                get(i,j)
            merge(i,0,0,1)
        
def go(it):

    global board, MAX
    
    board2 = [ x[:] for x in board ]
    
    if it == 5:
        t = max(map(max,board))
        if MAX < t:
            MAX = t
        return

    for i in range(4):
        move(i)
        go(it+1)
        board = [ x[:] for x in board2 ]

go(0)
print(MAX)
