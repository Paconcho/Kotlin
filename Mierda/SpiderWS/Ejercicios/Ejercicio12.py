def salario(horas, precio):
    if horas > 40:
        return (40 * precio) + ((horas - 40) * (precio * 1.5))
    else:
        return horas * precio


horas = int(input("Introduce el numero de horas trabajadas: "))
precio = int(input("Introduce el precio por hora trabajada: "))

resultado = salario(horas, precio)
print(f"El resultado es {resultado}")