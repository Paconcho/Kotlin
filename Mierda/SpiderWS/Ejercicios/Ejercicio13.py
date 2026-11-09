def adivina(numero):
    if numero % 2 == 0:
        return True
    else:
        return False
    
numero = int(input("Introduce un numero: "))    

if adivina(numero):
    print("Par")
else:
    print("Impar")
