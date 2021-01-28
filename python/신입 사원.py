import sys

N = int(sys.stdin.readline().strip('\n'))


def employ(a):

    a.sort()

    res = 1

    Max = a[0][1]
    
    for i in range(1,len(a)):
        if Max > a[i][1]:
            res +=1
            Max = a[i][1]
    return res

for _ in range(N):
    a = []
    n = int(sys.stdin.readline().strip('\n'))
    for __ in range(n):
        sc1,sc2 = map(int,sys.stdin.readline().strip('\n').split())
        a.append((sc1,sc2))

    print(employ(a))

# 1 4
# 2 2
# 3 3

# 4 1
