MAX = 1000000

prime = [0]*(MAX+1)
prime[0] = prime[1] = True

for i in range(2,MAX+1):
    if not prime[i]:
        j = i+i
        while j<= MAX:
            prime[j] = True
            j += i

n,m = map(int,input().split())

for i in range(n,m+1):
    if prime[i] == False:
        print(i)
