from itertools import combinations

while True:
    s = list(map(int,input().split()))
    if s == [0]:
        break

    for i in combinations(s[1:],6):
        print(' '.join(map(str,i)))
    print()
