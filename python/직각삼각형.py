while True:

    a = list(map(int,input().split()))

    if a[0] == a[1] and a[1] == a[2] and a[0] == 0:
        break
    a=sorted(a,reverse = True)

    
    if a[0]**2 == a[1]**2 + a[2]**2:
        print('right')
    else:
        print('wrong')
