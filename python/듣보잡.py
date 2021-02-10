N,M = map(int,input().split())

a = [ input() for _ in range(N)]

b = [ input() for _ in range(M)]

s1 = set(a)
s2 = set(b)

res_set = (s1 & s2)

res = list(res_set)
res.sort()

print(len(res))
for _ in res:
    print(_)
