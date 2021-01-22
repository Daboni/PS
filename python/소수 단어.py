# 백준 2153 번
"""
문제
소수란 1과 자기 자신으로만 나누어떨어지는 수를 말한다. 예를 들면 1, 2, 3, 5, 17, 101, 10007 등이 소수이다. 이 문제에서는 편의상 1도 소수로 하자.

알파벳 대소문자로 이루어진 영어 단어가 하나 있을 때, a를 1로, b를 2로, …, z를 26으로, A를 27로, …, Z를 52로 하여 그 합을 구한다.
예를 들어 cyworld는 합을 구하면 100이 되고, abcd는 10이 된다.

이와 같이 구한 수가 소수인 경우, 그 단어를 소수 단어라고 한다. 단어가 주어졌을 때, 그 단어가 소수 단어인지 판별하는 프로그램을 작성하시오.

입력
첫째 줄에 단어가 주어진다. 단어의 길이는 20자 이하이다. 주어지는 단어는 알파벳 소문자와 대문자만으로 이루어져 있다.

출력
아래의 예제와 같은 형식으로 출력을 한다. 소수 단어인 경우에는 It is a prime word.를, 아닌 경우에는 It is not a prime word.를 출력한다.
"""

prime = [1 for _ in range(1041)]
prime[0] = 0

for i in range(2,1041):
    if prime[i] == 1:
        for j in range(i*2,1041,i):
            prime[j] = 0

al = {}
cnt = 1
for i in range(ord('a'),ord('z')+1):
    al[chr(i)] = cnt
    cnt += 1

for i in range(ord('A'),ord('Z')+1):
    al[chr(i)] = cnt
    cnt += 1

s = input()
res = 0

for c in s:
    res += al[c]

if prime[res]:
    print("It is a prime word.")
else :
    print("It is not a prime word.")
