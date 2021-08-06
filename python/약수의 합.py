MAX = 1000000
cache = [1]*(MAX+1)
s = [0,1]

for i in range(2,MAX+1):
    j = i
    while j<= MAX:
        cache[j] += i
        j += i

for i in range(2,MAX+1):
    s.append(cache[i]+s[i-1])

T = int(input())

for i in range(T):
    n = int(input())
    print(s[n])
