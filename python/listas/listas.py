minha_lista = ["abacaxi", "melancia", "abacate"]
minha_lista_2 = [1, 2, 3, 4, 5]
minha_lista_3 = ["abacaxi", 2, 9.89, True]
print(minha_lista)
print(minha_lista_2)
print(minha_lista_3)

print(minha_lista[1])

for item in minha_lista:
    print(item)

tamanho = len(minha_lista)
print(tamanho)

minha_lista.append("limão")
print(minha_lista)

if 7 in minha_lista_2:
    print("7 está na lista")
else:
    print("7 não está na lista")

del minha_lista[2:]
print(minha_lista)

minha_lista_4 = []
minha_lista_4.append(57)
print(minha_lista_4)

lista = [124, 345, 5, 72, 46, 6, 7, 3, 1, 7, 0]
print(lista)

lista.sort()
print(lista)

lista.reverse()
print(lista)

lista2 = sorted(lista)
print(lista2)

lista2.reverse()
print(lista2)

lista3 = [124, 345, 5, 72, 46, 6, 7, 3, 1, 7, 0]
lista3.sort(reverse=True)
print(lista3)

lista4 = [124, 345, 5, 72, 46, 6, 7, 3, 1, 7, 0]
lista4.reverse()
print(lista4)