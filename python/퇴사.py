N = int(input())

a = [(0,0)]
for _ in range(N):
    t,p= map(int,input().split())
    a.append((t,p))

cache = [0]*(N+1)

for i in range(1,N+1):
    if i+a[i][0]-1 <= N:
        for j in range(i+1):
            if j+a[j][0] <= i:
                cache[i] = max(cache[i],a[i][1]+cache[j])

print(max(cache))
