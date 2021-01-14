# 1) 1
# 2) 2
# 3) 3
# 4) 5
# 5) 8
# 6) 13
# 7) 21
# 8) 34
# 9) 55

n = int(input())

res = [0,1,2]
for i in range(3,n+1):
    res.append(res[i-1]+res[i-2])

print(res[n]%10007)
