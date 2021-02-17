import sys

MAX = 1000000

prime = [0]*(MAX+1)
a = []

prime[0] = prime[1] = True

for i in range(2,MAX+1):
    if not prime[i]:
        a.append(i)
        j= i+i
        while j<=MAX:
            prime[j] = True
            j += i

while 1:
    n = int(sys.stdin.readline().strip('\n'))
    if n == 0:
        break

    for i in a:
        if prime[n-i] == False:
            print("{} = {} + {}".format(n,i,n-i))
            break
