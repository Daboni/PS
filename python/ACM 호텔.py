import sys

t = int(input())

for i in range(t):
    h,w,n = map(int,input().split())

    token = 0
    for x in range(1,w+1):
        for y in range(1,h+1):
            n -= 1
            if n == 0:
                if x<10:
                    token = 1
                    print(str(y)+'0'+str(x))
                    break
                else:
                    token = 1
                    print(str(y)+str(x))
                    break
        if token == 1:
            break
