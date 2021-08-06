N = int(input())

a = [0 for i in range(26)]

for i in range(N):
    s = input()
    a[ord(s[0])-97] += 1

res = ""

for i,j in enumerate(a):
    if j >= 5:
        res += chr(i+97)

if res == "":
    print("PREDAJA")
    
print(res)
