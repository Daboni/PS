K = int(input())

a = []
for i in range(K):
    s = input()
    if s == '0':
        a.pop()
    else:
        a.append(int(s))

print(sum(a))
