from collections import deque

prime = [True] * 10001

prime[0] = prime[1] = False

for i in range(2,10001):

    j = 2
    while i*j < 10001:
        prime[i*j] = False
        j += 1

t = int(input())


def change(num,index,digit):
    if index == 0 and digit == 0:
        return -1

    num = list(str(num))
    num[index] = chr(digit+ord('0'))

    return int(''.join(num))

while t:
    n,m = map(int,input().split())

    d = [-1]*10001

    q = deque()
    q.append(n)
    d[n] = 0

    while q:
        now = q.popleft()

        for i in range(4):
            for j in range(10):
                nxt = change(now,i,j)
                if prime[nxt] and d[nxt] == -1:
                    d[nxt] = d[now]+1
                    q.append(nxt)
                    

    print(d[m] if d[m]!=-1 else 'impossible')
    t-=1
                
