from collections import deque

MAX = 200000

dist = [-1] * (MAX+1)
track = [-1] * (MAX+1)
q = deque()

n,m = map(int,input().split())

q.append(n)
dist[n] = 0
while q:
    now = q.popleft()
    for nxt in [ now-1, now+1, 2*now ]:
        if 0<= nxt <= MAX and dist[nxt] == -1:
            q.append(nxt)
            dist[nxt] = dist[now]+1
            track[nxt]=now

print(dist[m])

s = []
while True:
    if m == -1:
        break
    s.append(m)
    m = track[m]

while s:
    print(s.pop(),end = ' ')
