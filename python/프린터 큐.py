from collections import deque

t = int(input())

while t!=0:
    n,m = map(int,input().split())
    q = deque(list(map(int,input().split())))
    q_index = deque([ i for i in range(len(q)) ])
    cnt = 0
    while q:
        if q[0] == max(q):
            cnt += 1
            if q_index[0] == m:
                print(cnt)
                break
            q.popleft()
            q_index.popleft()
        else:
            q.append(q.popleft())
            q_index.append(q_index.popleft())

    t  -= 1
