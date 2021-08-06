import sys

n,m = map(int,input().split())

a = [0]*m

def go(index,selected,n,m):
    if selected == m:
        sys.stdout.write(' '.join(map(str,a))+'\n')
        return
    
    if index>n:
        return
    
    a[selected] = index
    go(index+1,selected+1,n,m)
    a[selected] = 0
    go(index+1,selected,n,m)

go(1,0,n,m)
