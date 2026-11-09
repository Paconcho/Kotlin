def impuesto(ingresos, hijos):
    ingreso_imponible = ingresos - 600 - (60 * hijos)
    return ingreso_imponible/3

ingresos = float(input("Introduce los ingresos totales: "))
hijos = int(input("Introduce el numero de hijos: "))
print(round(impuesto(ingresos, hijos)))