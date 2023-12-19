salary=int(input("enter the salary:"))
age=int(input("enter the age:"))
if(salary>=20000 or age<=25):
    loan=int(input("enter the loan amount:"))
    if(loan>50000):
        print("maximum loan amount is 50000")
    else:
        print("you are eligiable for loan")
else:
    print(";you are not eligiable for loan")