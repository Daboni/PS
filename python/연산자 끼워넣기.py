n = int(input())

a = list(map(int,input().split()))

op = list(map(int,input().split()))

MAX = -1e9
MIN = 1e9

def go(index,s):
    global MAX
    global MIN
    
    if index == n:
        if MAX < s :
            MAX = s
        if MIN > s:
            MIN = s
        return

    if op[0] != 0:
        op[0] -= 1
        go(index+1,s+a[index])
        op[0] += 1
    if op[1] != 0:
        op[1] -= 1
        go(index+1,s-a[index])
        op[1] += 1
    if op[2] != 0:
        op[2] -= 1
        go(index+1,s*a[index])
        op[2] += 1
    if op[3] != 0:
        op[3] -= 1
        if s > 0:
            go(index+1,s//a[index])
        else:
            go(index+1,-(abs(s)//a[index]))
        op[3] += 1

go(1,a[0])

print(MAX)
print(MIN)
