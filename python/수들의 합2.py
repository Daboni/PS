import sys

n,m = map(int,sys.stdin.readline().strip('\n').split())

a = list(map(int,sys.stdin.readline().strip('\n').split()))

ans = 0

right,left,s = 0,0,0
s = a[right]

while left <= right and right<n:

    if s<m:
        right+=1
        if right < n:
            s+=a[right]
    elif s==m:
        ans += 1
        right+=1
        if right<n:
            s+=a[right]
    else:
        s-=a[left]
        left += 1
        if left>right and left<n:
            right=left
            s=a[right]


print(ans)
