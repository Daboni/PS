import sys

s = sys.stdin.readline().strip('\n')

a = list(map(int,s))

def u(a):

    for i in range(1,len(a)):
        tmp1 = 1
        tmp2 = 1
        for j in a[:i]:
            tmp1 *= j
        for k in a[i:]:
            tmp2 *= k

        if tmp1 == tmp2:
            return True
    return False

if u(a):
    print('YES')
else:
    print('NO')
