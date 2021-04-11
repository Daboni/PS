def go(a,index, ans):

    if len(ans) == 6:
        print(' '.join(map(str,ans)))
        return

    if index == len(a):
        return
    
    go(a,index+1, ans+[a[index]])
    go(a,index+1, ans)


while True:
    a = list(map(int,input().split()))
    if a[0] == 0:
        break

    go(a[1:],0,[])
    print()
