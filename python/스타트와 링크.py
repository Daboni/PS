n = int(input())

a = [ list(map(int,input().split())) for i in range(n) ]

def go(index,first,second):

    if index == n:
        if len(first) != n//2:
            return -1
        if len(second) != n//2:
            return -1

        t1 = 0
        t2 = 0

        for i in range(n//2):
            for j in range(n//2):
                if i == j :
                    continue
                t1 += a[first[i]][first[j]]
                t2 += a[second[i]][second[j]]

        diff = abs(t1-t2)
        return diff
    
    if len(first)>n//2:
        return -1
    if len(second)>n//2:
        return -1

    ans = -1

    t1 = go(index+1,first+[index],second)

    if ans == -1 or ( t1 != -1 and ans> t1):
        ans = t1

    t2 = go(index+1,first,second+[index])

    if ans == -1 or ( t2 != -1 and ans>t2):
        ans = t2

    return ans

print(go(0,[],[]))
