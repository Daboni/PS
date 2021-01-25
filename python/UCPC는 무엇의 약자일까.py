import sys

s = sys.stdin.readline()

res = ""
idx = s.find('U')
if idx == -1:
    print('I hate UCPC')
    
else:
    s=s[idx:]
    idx = s.find('C')
    if idx == -1:
        print('I hate UCPC')
    else:
        s = s[idx:]
        idx = s.find('P')
        if idx == -1:
            print('I hate UCPC')
        else:
            s=s[idx:]
            idx=s.find('C')
            if idx == -1:
                print('I hate UCPC')
            else:
                print('I love UCPC')
