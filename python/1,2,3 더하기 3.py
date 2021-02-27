cache = [0]*1000001
cache[0] = 1

for i in range(1,1000001):
    if i-1>=0:
        cache[i] += cache[i-1]
    if i-2>=0:
        cache[i] += cache[i-2]
    if i-3>=0:
        cache[i] += cache[i-3]

    cache[i] %= 1000000009

t = int(input())

for i in range(t):
    n = int(input())
    print(cache[n])
    
