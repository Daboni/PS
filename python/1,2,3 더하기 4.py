n = int(input())
d = [0] * 10001
d[0] = 1

for i in range(1,10001):
    if i-1 >= 0:
        d[i] += d[i-1]

for i in range(1,10001):
    if i-2 >= 0:
        d[i] += d[i-2]

for i in range(1,10001):
    if i-3 >= 0:
        d[i] += d[i-3]

for i in range(n):
    k = int(input())
    print(d[k])
