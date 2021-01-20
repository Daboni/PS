# 백준 2711 

N = int(input())

for i in range(N):
    idx,s = input().split()
    idx = int(idx)-1
    s = s[:idx] + s[idx+1:]
    print(s)
