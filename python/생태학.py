import sys

#s = sys.stdin.read().split('\n')
s="""Red Alder
Ash
Aspen
Basswood
Ash
Beech
Yellow Birch
Ash
Cherry
Cottonwood
Ash
Cypress
Red Elm
Gum
Hackberry
White Oak
Hickory
Pecan
Hard Maple
White Oak
Soft Maple
Red Oak
Red Oak
White Oak
Poplan
Sassafras
Sycamore
Black Walnut
Willow
""".split('\n')
s = sorted(s)

dic = {}
n = 0
for i in s:
    if i != '':
        if i in dic.keys():
            dic[i] += 1
        else:
            dic[i] = 1
        n += 1
for i in dic:
    
    print('%s %.4f'%(i,round(dic[i]/n*100,4)))
