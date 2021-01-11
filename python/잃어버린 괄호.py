s = input()
a = []

string = ""
for i in s:
    if i != '-' and i != '+':
        string += i
    else:
        if string != '':
            a.append(str(int(string)))
            string = ""
        a.append(i)
a.append(str(int(string)))

s = ""
for i in a:
    s += i

a = []
while(s.find('-')!=-1):
    index = s.find('-')
    a.append(s[:index])
    a.append('-')
    s = s[index+1:]

a.append(s)
if a[0] == '':
    del a[0]
for i,j in enumerate(a):
    if j != '-':
        a[i]=eval(j)

res = ""
for i in a:
    res += str(i)

print(eval(res))
