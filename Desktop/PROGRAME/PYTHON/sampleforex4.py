a=[]
for i in range(7):
    num=int(input("enter number:" +str(i+1)))
    a.append(num)
print(a)

sum=0
for i in a:
    sum=sum+i
print(sum)