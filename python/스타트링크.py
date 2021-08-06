from collections import deque

f,s,g,u,d = map(int,input().split())
# f : 건물의 높이
# s : 현재 층
# g : 목표 층
# u : 올라가는 층
# d : 내려가는 층

limit = 1000000

dist = [-1]*(limit+1)
q = deque()
q.append(s)
dist[s] = 0

while q:

    now = q.popleft()
    if now == g:
        break

    if 1<= now+u <= f and dist[now+u] == -1:
        q.append(now+u)
        dist[now+u] = dist[now]+1
        
    if 1<= now-d <= f and dist[now-d] == -1:
        q.append(now-d)
        dist[now-d] = dist[now]+1 

print(dist[g] if dist[g] != -1 else 'use the stairs')
