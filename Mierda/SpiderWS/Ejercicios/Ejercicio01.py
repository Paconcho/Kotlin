def mayor(a,b):
    if a > b:
        return a
    elif a == b:
        return 0
    else:
        return b
    
a = input("Introduce el valor de a: ")
b = input("Introduce el valor de b: ")

print(mayor(a,b))