import sys

n,m = map(int,sys.stdin.readline().strip('\n').split())

a = list(map(int,sys.stdin.readline().strip('\n').split()))

right = left = 0

s = a[0]

ans = 1e9

while left<=right and right<n:

    if s<m:
        right += 1
        if right < n:
            s += a[right]
    else:
        ans = min(ans,right-left+1)
        s -= a[left]
        left += 1
        if left>right and left < n:
            right = left
            s = a[right]

print(ans if ans<1e9 else 0 )
