import sys

n,m = map(int,sys.stdin.readline().strip('\n').split())

a = list(map(int,sys.stdin.readline().strip('\n').split()))

ans = 0
ans_sum = 99999999
for i in range(n):
    for j in range(i+1,n):
        for k in range(j+1,n):
            Sum = a[i]+a[j]+a[k]
            if Sum > m:
                continue
            tmp = m-Sum
            if ans_sum>tmp:
                ans_sum = tmp
                ans = Sum

print(ans)
