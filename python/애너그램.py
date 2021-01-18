# 백준 6996 번
"""
문제
두 단어 A와 B가 주어졌을 때, A에 속하는 알파벳의 순서를 바꾸어서 B를 만들 수 있다면, A와 B를 애너그램이라고 한다.

두 단어가 애너그램인지 아닌지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수(<100)가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 100을 넘지 않는 단어가 공백으로 구분되어서 주어진다.
단어는 알파벳 소문자로만 이루어져 있다.
"""

N = int(input())

for i in range(N):
    s1,s2 = input().split()
    if len(s1) != len(s2):
        print('{} & {} are NOT anagrams.'.format(s1,s2))
        continue
    tmp_s1 = sorted(s1)
    tmp_s2 = sorted(s2)
    for j in range(len(s1)):
        if tmp_s1[j] != tmp_s2[j]:
            print('{} & {} are NOT anagrams.'.format(s1,s2))
            break
        if tmp_s1[j] == tmp_s2[j] and j == len(s1)-1:
            print('{} & {} are anagrams.'.format(s1,s2))
