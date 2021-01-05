#백준 9251번 LCS
"""
문제

LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때, 모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.

예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

"""

a = input()
b = input()

c = [ [ 0 for col in range(len(b)+1)] for row in range(len(a)+1)]

def lcs(x,y):
    for i in range(1,len(a)+1):
        for j in range(1,len(b)+1):
            
            if a[i-1] == b[j-1] :
                c[i][j] = c[i-1][j-1]+1
            else :
                c[i][j] = max(c[i][j-1],c[i-1][j])

    return c[i][j]


print(lcs(a,b))
