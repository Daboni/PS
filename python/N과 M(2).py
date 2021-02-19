import sys

n,m = map(int,input().split())

c = [False]*(n+1)
a = [0]*(m+1)

def go(index,n,m):
    if index == m:
        sys.stdout.write(' '.join(map(str,a[1:]))+'\n')
        return
    for i in range(1,n+1):

        if c[i] == True or a[index-1] > i:
            continue
        c[i] = True
        a[index] = i
        go(index+1,n,m)
        c[i] = False

go(1,n,m+1)
