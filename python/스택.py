import sys

n = int(sys.stdin.readline().strip('\n'))

a = []


for i in range(n):

    s = sys.stdin.readline().strip('\n').split()

    if s[0] == 'push':
        a.append(s[1])
    elif s[0] == 'pop':
        if len(a) == 0:
            print(-1)
            continue
        print(a.pop())
    elif s[0] == 'size':
        print(len(a))
    elif s[0] == 'empty':
        if len(a) == 0:
            print(1)
        else:
            print(0)
    elif s[0] == 'top':
        if len(a) == 0:
            print(-1)
            continue
        print(a[-1])

