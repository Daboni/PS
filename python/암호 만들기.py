n,m = map(int,input().split())

al = input().split()
a = [0]*n
al.sort()

def check(a):

    mo = 0
    ja = 0

    for c in a:
        if c in 'aeiou':
            mo += 1
        else:
            ja += 1
        if mo >= 1 and ja >= 2:
            return True
    return False

def go(index,start,n,m):
    if index == n:
        if check(a):
            print(''.join(a))
            return
        else:
            return
        
    for i in range(start,m):
        a[index] = al[i]
        go(index+1,i+1,n,m)

go(0,0,n,m)
