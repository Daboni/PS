N = int(input())

a = list(map(int,input().split()))

op = list(map(int,input().split()))

max_ = -1e9
min_ = 1e9

def dfs(idx, res):
    global max_,min_

    if idx == N:
        max_ = max(max_,res)
        min_ = min(min_,res)
        return

    if op[0]>0:
        op[0] -= 1
        dfs(idx+1,res+a[idx])
        op[0] += 1
    if op[1]>0:
        op[1] -= 1
        dfs(idx+1,res-a[idx])
        op[1] += 1
    if op[2]>0:
        op[2] -= 1
        dfs(idx+1,res*a[idx])
        op[2] += 1
    if op[3]>0:
        op[3] -= 1
        dfs(idx+1,int(res/a[idx]))
        op[3] += 1

dfs(1,a[0])
print(max_)
print(min_)
