prime = [1 for _ in range(1041)]
prime[0] = 0

for i in range(2,1041):
    if prime[i] == 1:
        for j in range(i*2,1041,i):
            prime[j] = 0

al = {}
cnt = 1
for i in range(ord('a'),ord('z')+1):
    al[chr(i)] = cnt
    cnt += 1

for i in range(ord('A'),ord('Z')+1):
    al[chr(i)] = cnt
    cnt += 1

s = input()
res = 0

for c in s:
    res += al[c]

if prime[res]:
    print("It is a prime word.")
else :
    print("It is not a prime word.")
