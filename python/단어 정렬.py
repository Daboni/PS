import sys

N = int(sys.stdin.readline().strip('\n'))

a = []

for i in range(N):
    s = sys.stdin.readline().strip('\n')
    a.append(s)
    
a = list(set(a))


sorted_a = []

for i in a:
    sorted_a.append((len(i),i))

sorted_a.sort()

for len_s,s in sorted_a:
    print(s)
