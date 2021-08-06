# d[n] = d[n

n = int(input())

cache = [0] * (n+1)

for i in range(1,n+1):
    cache[i] = i
    j = 1
    while j*j <= i:
        if cache[i] > cache[i-j*j]+1:
            cache[i] = cache[i-j*j]+1
        j+=1

print(cache[n])
