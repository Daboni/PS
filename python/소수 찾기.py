MAX = 1000001

prime = [0]*MAX

prime[0] = True
prime[1] = True

for i in range(2,MAX):
    if not prime[i]:
        j = i+i
        while j<MAX:
            prime[j] = True
            j += i

n = int(input())

a = list(map(int,input().split()))

res = 0
for i in range(n):
    if prime[a[i]] == False:
        res += 1

print(res)
