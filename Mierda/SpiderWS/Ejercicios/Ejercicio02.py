def mayor_edad(edad):
    if edad >= 18:
        return True
    else:
        return False
    
edad = int(input("Introduce tu edad: "))

if mayor_edad(edad):
    print("Si")
else:
    print("Noç")

