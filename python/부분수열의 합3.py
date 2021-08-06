n = int(input())
a = list(map(int,input().split()))
c = [False] * (20*100000+10)
for i in range(1<<n):
    s = 0
    for j in range(n):
        if (i&(1<<j)):
            s += a[j]
    c[s] = True

i = 1
while True:
    if c[i] == False:
        print(i)
        break
    i += 1
