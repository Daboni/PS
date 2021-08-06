n = int(input())

a = [ int(input()) for _ in range(n) ]

a = sorted(a)

print(round(sum(a)/len(a)))

print(a[n//2])

MIN = a[0]
MAX = a[-1]

tmp = [ 0 for _ in range(MAX+abs(MIN)+1) ]

for i in a:
    tmp[i+abs(MIN)] += 1

t_max = max(tmp)
ans = -1
for i in range(len(tmp)):
    if tmp[i] == t_max:
        if ans == -1:
           ans = i
        else:
            ans = i
            break

print(ans-abs(MIN))
print(MAX-MIN)
