import sys

N = sys.stdin.readline().strip('\n')

N = sorted(N,reverse=True)

res = ""
for i in N:
    res += i
print(int(res))
