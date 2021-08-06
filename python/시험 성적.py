import bisect

s = [60,70,80,90]
g = ['F','D','C','B','A']

n=int(input())
print(g[bisect.bisect_right(s,n)])
