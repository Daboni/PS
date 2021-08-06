n = int(input())

a = []

for i in range(n):
    age, name = input().split()

    a.append(((int(age),name),i))

a = sorted(a, key = lambda x : (x[0][0], x[1]))

for i in a:
    print(i[0][0],i[0][1])
