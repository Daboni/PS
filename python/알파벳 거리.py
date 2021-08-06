import sys

n = int(sys.stdin.readline().strip('\n'))

for _ in range(n):
    s = sys.stdin.readline().strip('\n').split()
    a = []
    print("Distances:",end = ' ')
    
    for i in range(len(s[0])):
        dis = ord(s[1][i]) - ord(s[0][i])
        if dis < 0:
            dis += 26
        print(dis,end=' ')
    print()
