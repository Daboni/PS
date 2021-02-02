# 0000  1001
# 0010  1011
# 0000  1001

# -100  00-1    1110
# -100  00-1    1100
# -100  00-1    1110

# 011   11-1    
# 01-1  1-1-1
# 011   11-1

import sys

n,m = map(int,sys.stdin.readline().strip('\n').split())

A = [ list(sys.stdin.readline().strip('\n')) for __ in range(n) ]

B = [ list(sys.stdin.readline().strip('\n')) for __ in range(n)]

C =[ [0 for _ in range(m)] for __ in range(n)]

k = 0

res = 0
if n < 3 or m < 3:
    for i in range(n):
        for j in range(m):
            if A[i][j] != B[i][j]:
                k = 1
    
else:
    for i in range(n-2):
        for j in range(m-2):
            if A[i][j] != B[i][j]:
                for p in range(i,i+3):
                    for q in range(j,j+3):
                        if A[p][q] == '0':
                            A[p][q] = '1'
                        else:
                            A[p][q] = '0'
                res += 1


for i in range(n):
    for j in range(m):
        if A[i][j] != B[i][j]:
            k = 1
if k == 1:
    print(-1)
else:
    print(res)
