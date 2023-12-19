s_username="emc"
s_password="123"
user=input("enter the user:")
pas=input("enter the pass:")
def validate():
    if(s_username==user and s_password==pas):
        return True
    else:
         return False
a=validate()
print(a)