import sys

m = int(sys.stdin.readline().strip('\n'))

check = [False]*(m+1)

prime = []

for i in range(2,m+1):

    if check[i] == False:
        prime.append(i)
        j = 2
        while i*j <= m:
            check[i*j] = True
            j += 1


n = len(prime)

right = left = 0
s = prime[0] if len(prime) != 0 else 0

ans = 0

while left<=right and right < n:
    
    if s<m:
        right += 1
        if right < n:
            s += prime[right]

    elif s == m:
        ans += 1
        right += 1
        if right < n :
            s += prime[right]

    else:
        s -= prime[left]
        left += 1
        if left > right and left < n:
            right = left
            s = prime[left]

print(ans)
