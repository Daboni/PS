import operator

N = int(input())

a = [input() for _ in range(N)]

alpha = { }

for i in a:
    it = 0
    for j in i:
        if j in alpha :
            alpha[j] += 10 ** (len(i)-1-it)
        else:
            alpha[j] = 10 ** (len(i)-1-it)
        it += 1

alpha = sorted(alpha.items(),reverse=True, key = operator.itemgetter(1))

cnt = 9
res = 0
for i in alpha:
    res += i[1] * cnt
    cnt -= 1
    
print(res)
