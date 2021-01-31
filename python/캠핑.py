# 8 8 4
# 5 5 4 14
# 3 3 3 9

import sys

i = 1

while(1):
    L,P,V = map(int,sys.stdin.readline().strip('\n').split())

    res = 0
    

    if L == 0 and P == 0 and V == 0:
        break

    res = V//P*L + min(L,V-P*(V//P))

    print("Case {}: {}".format(i,res))

    i += 1
