n = int(input())

res = 0

for i in range(1,n+1):
    res = res + n//i*i

print(res)
