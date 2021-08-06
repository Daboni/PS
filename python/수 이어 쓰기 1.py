n = int(input())

start = 1
res = 0
length = 1

while start<=n:
    last = start*10-1
    if last >= n:
        last = n

    res += (last-start+1)*length
    length += 1
    start *= 10

print(res)
