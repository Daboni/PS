n = int(input())
s = input()

a = [ [0]*n for i in range(n) ]
ans = [0] *n

cnt = 0
for i in range(n):
    for j in range(i,n):
        if s[cnt] == '+':
            a[i][j] = 1
        elif s[cnt] == '-':
            a[i][j] = -1
        else:
            a[i][j] = 0
        cnt += 1

def check(index):
    s = 0
    for i in range(index,-1,-1):
        s += ans[i]
        if a[i][index] == 0:
            if s != 0:
                return False
        elif a[i][index] < 0:
            if s >= 0:
                return False
        else:
            if s <= 0:
                return False
    return True

def go(index):
    if index == n:
        return True
    if a[index][index] == 0:
        ans[index] = 0
        return check(index) and go(index+1)

    for i in range(1,11):
        ans[index] = i*a[index][index]
        if check(index) and go(index+1):
            return True
    return False

go(0)
print(' '.join(map(str,ans)))
