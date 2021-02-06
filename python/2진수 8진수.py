# 백준 1373 번
"""
문제
2진수가 주어졌을 때, 8진수로 변환하는 프로그램을 작성하시오.

입력
첫째 줄에 2진수가 주어진다. 주어지는 수의 길이는 1,000,000을 넘지 않는다

출력
첫째 줄에 주어진 수를 8진수로 변환하여 출력한다.
"""

s = input()

s = list(s)
s.reverse()

l = len(s)//3
r = len(s)%3
a=[]

for i in range(l):
    tmp =0 
    temp = s[i*3:i*3+3]
    if temp[0] == '1':
        tmp += 1
    if temp[1] == '1':
        tmp += 2
    if temp[2] == '1':
        tmp += 4
    a.append(str(tmp))
    tmp = 0

if r == 1:
    temp = s[len(s)-r:]
    tmp = 0
    if temp[0] == '1':
        tmp += 1
    a.append(str(tmp))
    tmp = 0



if r == 2:
    temp = s[len(s)-r:]
    tmp = 0
    if temp[0] == '1':
        tmp += 1
    if temp[1] == '1':
        tmp += 2
    a.append(str(tmp))
    tmp = 0


a.reverse()

res = ''.join(a)

print(int(res))
