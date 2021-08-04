T = int(input())


while True:
    if T == 0:
        break
    dic = {}
    arr = list(map(int,input().split()))
    n = arr[0]
    for k in arr:
        if k == 0: continue
        if k not in dic:
            dic[k] = 1
        else:
            dic[k]+=1
    ans = 0;
    for key in dic:
        if dic[key] > n/2:
            ans = key;
            break;

    if ans==0:
        print("SYJKGW")
    else:
        print(ans)
    T-=1
