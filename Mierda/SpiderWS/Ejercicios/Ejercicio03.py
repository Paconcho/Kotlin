def micro(empleados, dinero, balance):
    if empleados < 50:
        return True
    else:
        return False
    if dinero < 30:
        return True
    else:
        return False
    if balance <= 5:
        return True
    else:
        return False
    
empleados = int(input("Introduce el numero de empleados: "))
dinero = int(input("Introduce la cantidad de dinero facturada: "))
balance = int(input("Introduce el balance de la empresa del ultimo año: "))

if micro(empleados, dinero, balance):
    print("Si es")
else: 
    print("No es")