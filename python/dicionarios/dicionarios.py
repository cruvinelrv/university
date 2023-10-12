dicionario = {'nome': 'Guilherme', 'idade': 27, 'altura': 1.80}

print(dicionario)

print(dicionario['nome'])

print(dicionario['idade'])

print(dicionario['altura'])

dicionario['idade'] = 28
print(dicionario)

for chave in dicionario:
    print(chave)

for chave in dicionario:
    print(dicionario[chave])

for chave in dicionario:
    print(chave + ': ' + str(dicionario[chave]))

for chave in dicionario.values():
    print(chave)

for chave in dicionario.keys():
    print(chave)

for chave, valor in dicionario.items():
    print(chave + ': ' + str(valor))