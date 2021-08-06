import sys

#input = sys.stdin.readline

n,m = map(int,sys.stdin.readline().split())

a = list(map(int,sys.stdin.readline().split()))

low = 1
high = max(a)

mid = 0
while low <= high:
    mid = (low+high)//2

    s = 0
    for log in a:
        if log > mid:
            s += (log-mid)

    if s>=m:
        low = mid+1
    else:
        high = mid-1

print(high)
