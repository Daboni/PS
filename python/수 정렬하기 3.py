import sys

n = int(sys.stdin.readline())

a = [0] * 10001

for i in range(n):
    a[int(sys.stdin.readline())] += 1

for i in range(1,10001):

    if a[i] != 0:
        while a[i] != 0:
            print(i)
            a[i] -= 1

