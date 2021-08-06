import itertools

n =10
m=12
k=8
ans =0
a = []

for i in itertools.product(range(1,k+1),repeat=n):
    a.append(i)

for i in range(len(a)):
    if sum(a[i]) == m:
        ans+=1

print(ans)
