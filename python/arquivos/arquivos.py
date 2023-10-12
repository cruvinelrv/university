clear = lambda: print('\033c')
arquivo = open('../../../olamundo.txt')
texto_completo = arquivo.read()
print(texto_completo)
