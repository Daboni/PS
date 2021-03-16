from collections import deque
MAX = 200000

n,m = map(int,input().split())

dist = [-1] * (MAX+1)
q = deque()
q.append(n)
dist[n] = 0

while q:
    now = q.popleft()
    if 2*now <= MAX and dist[2*now] == -1:
        q.appendleft(2*now)
        dist[2*now] = dist[now]

    if 0 <= now-1 and dist[now-1] == -1:
        q.append(now-1)
        dist[now-1] = dist[now] +1
    if now+1 <= MAX and dist[now+1] == -1:
        q.append(now+1)
        dist[now+1] = dist[now] + 1

print(dist[m])
