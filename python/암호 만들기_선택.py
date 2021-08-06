n,m = map(int,input().split())

al = input().split()
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

def go(n, alpha, password, i):
    if len(password) == n:
        if check(password):
            print(password)
        return

    if i == len(alpha):
        return

    go(n, alpha, password+al[i], i+1)
    go(n, alpha, password, i+1)

go(n,al,"",0)
