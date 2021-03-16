from collections import deque

MAX = 200000
n,m = map(int,input().split())

dst = [ -1 for _ in range(MAX+1) ]

q = deque()
q.append(n)
dst[n] = 0
while q:
    now = q.popleft()
    for nxt in [ now-1, now+1, 2*now]:
        if 0<=nxt<=MAX and dst[nxt] == -1:
            dst[nxt] = dst[now]+1
            q.append(nxt)

print(dst[m])
            
