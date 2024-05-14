import random

"""
Nome: imprimirMenuPrincipal
Objetivo: imprimir o menu principal com as opcoes disponiveis
inputs: nao ha
retorno: nao ha
"""
def imprimirMenuPrincipal():
   print("Atividades disponiveis:")
   print("1 - Gerenciar arquivo de palavras")
   print("2 - Jogar")
   print("3 - Sair\n")

"""
Nome: imprimirMenuArquivos
Objetivo: imprimir o menu de arquivos com as opcoes disponiveis
inputs: nao ha
retorno: nao ha
"""
def imprimirMenuArquivos():
   print("Atividades disponiveis:")
   print("1 - Adicionar palavra")
   print("2 - Excluir palavra")
   print("3 - Voltar\n")

"""
Nome: adicionarPalavra
Objetivo: adicionar palavra no arquivo de palavras caso ela ainda nao esteja nele
inputs: palavra - string contendo a palavra a ser adicionada
retorno:
   - True se a palavra foi adicionada
   - False se a palavra nao foi adicionada
"""
def adicionarPalavra(palavra):
   contido = False
   arquivo.seek(0)
   # confere se a palavra ja esta contida no arquivo
   for linha in arquivo:
      if (palavra+"\n"==linha):
         contido = True
   # se estiver, nao adiciona e retorna False
   if (contido):
      return False
   # se nao estiver, adiciona e retorna True
   else:
      arquivo.write(palavra.lower() + "\n")
      return True

"""
Nome: removerPalavra
Objetivo: remover palavra do arquivo de palavras caso ela esteja nele
inputs: palavra - string contendo a palavra a ser removida
retorno:
   - True se a palavra foi removida
   - False se a palavra nao foi removida
"""
def removerPalavra(palavra):
   arquivo.seek(0)
   # le as palavras do arquivo como uma lista de strings
   linhas = arquivo.readlines()
   # confere se a palavra esta no arquivo
   if (palavra+"\n" in linhas):
      # remove a string da lista
      linhas.remove(palavra+"\n")
      arquivo.seek(0)
      # limpa o arquivo
      arquivo.truncate()
      # escreve a lista novamente no arquivo, dessa vez sem a palavra removida
      for linha in linhas:
         arquivo.write(linha)
      return True
   else:
      return False

"""
Nome: lerLetra
Objetivo: ler uma letra e conferir se ela ja foi tentada
inputs:
   - letrasTentadas: lista contendo as letras ja tentadas no jogo
   - texto: string contendo o texto para ir na leitura da letra
retorno: letra - letra final lida
"""
def lerLetra(letrasTentadas, texto):
   letra = input(texto)
   # confere se a pessoa ja tentou a letra digitada
   while (letra in letrasTentadas):
      letra = input("Voce ja tentou essa letra! Tente outra: ")
   print()
   return letra

"""
Nome: imprimirSituacao
Objetivo: imprimir dados da situacao atual do jogo, o que inclui:
   - as letras ja tentadas
   - o numero de erros
   - as letras ja reveladas da palavra
   - a palavra secreta com as letras ja reveladas em suas posicoes corretas e com "_" no lugar das letras ainda nao reveladas
inputs:
   - palavraSecreta: string contendo a palavra sorteada
   - letrasTentadas: lista contendo as letras ja tentadas no jogo
   - erros: int contendo o numero de erros cometidos
   - letrasReveladas: lista contendo as letrad ja reveladas da palavra
retorno: nao ha
"""
def imprimirSituacao(palavraSecreta, letrasTentadas, erros, letrasReveladas):
   print("Letras ja tentadas:", letrasTentadas)
   print("Erros cometidos:", erros)
   print("Letras reveladas:", letrasReveladas)
   print("Situacao atual: ", end="")
   # imprime a palavra com as ja reveladas em suas posicoes corretas e com um "_" no lugar das letras nao reveladas
   for caractere in palavraSecreta:
      if caractere in letrasReveladas:
         print(caractere, " ", sep="", end="")
      else:
         print("_ ", sep="", end="")
   print()
   print()

"""
Nome: jogar
Objetivo: executar o jogo da forca
inputs: palavraSecreta - string contendo a palavra sorteada
retorno:
   - True se a pessoa descobriu a palavra
   - False se a pessoa nao descobriu a palavra
"""
def jogar(palavraSecreta):
   erros = 0
   acertos = 0
   vencedor = False
   letrasTentadas = []
   letrasReveladas = []
   letra = lerLetra(letrasTentadas, "Escolha uma letra: ")
   while (erros<5 and not vencedor):
      # adiciona a letra digitada na lista de letras tentadas
      letrasTentadas.append(letra)
      # confere se a letra digitada esta na palavra
      if (letra in palavraSecreta):
         print("A palavra possui a letra '", letra, "'", sep="")
         letrasReveladas.append(letra)
         acertos += palavraSecreta.count(letra)
      else:
         print("A palavra nao possui a letra '", letra, "'", sep="")
         erros += 1
      # organiza as lista de letras tentadas e de letras reveladas
      letrasTentadas.sort()
      letrasReveladas.sort()
      imprimirSituacao(palavraSecreta, letrasTentadas, erros, letrasReveladas)
      # confere se a pessoa ja revelou todas as letras
      if (len(palavraSecreta)==acertos):
         vencedor = True
      # confere se a pessoa errou menos de 5 vezes
      if (erros<5 and not vencedor):
         letra = lerLetra(letrasTentadas, "Escolha outra letra: ")
   return vencedor

arquivo = open("palavras.txt", "a+")

print("Bem-vindo ao Jogo da Forca!\n")
imprimirMenuPrincipal()
opcaoPrincipal = int(input("Escolha uma opcao: "))
print()

while (opcaoPrincipal!=3):
   if (opcaoPrincipal==1):
      imprimirMenuArquivos()
      opcaoArquivos = int(input("Escolha uma opcao: "))
      print()
      # continua no menu de arquivos enquanto a pessoa nao optar por voltar
      while (opcaoPrincipal==1):
         if (opcaoArquivos==1):
            palavra = input("Digite a palavra a ser adicionada: ")
            sucesso = adicionarPalavra(palavra)
            if (sucesso):
               print("A palavra foi adicionada com sucesso\n")
            else:
               print("A palavra nao foi adicionada pois ja esta no arquivo\n")
            opcaoArquivos = int(input("Escolha outra opcao: "))
            print()
         elif (opcaoArquivos==2):
            palavra = input("Digite a palavra a ser excluida: ")
            sucesso = removerPalavra(palavra)
            if (sucesso):
               print("A palavra foi removida com sucesso\n")
            else:
               print("A palavra nao foi removida pois nao estava contida no arquivo\n")
            opcaoArquivos = int(input("Escolha outra opcao: "))
            print()
         elif (opcaoArquivos==3):
            imprimirMenuPrincipal()
            opcaoPrincipal = int(input("Escolha uma opcao: "))
            print()
            break
         else:
            print("Opcao invalida")
            opcaoArquivos = int(input("Escolha uma opcao: "))
            print()
   elif (opcaoPrincipal==2):
      arquivo.seek(0)
      # le as palavras do arquivo como uma lista de strings
      palavras = arquivo.readlines()
      # escolhe uma palavra aleatoria a partir da lista
      palavraSecreta = random.choice(palavras)[:-1]
      print("Jogo iniciado! Sorteando palavra...")
      print("A palavra sorteada possui", len(palavraSecreta), "letras")
      print("Se voce descobrir a palavra com menos de 5 erros, voce vence!\n")
      sucesso = jogar(palavraSecreta)
      if (sucesso):
         print("Parabens! Voce venceu!\n")
      else:
         print("Nao foi dessa vez! A palavra era '", palavraSecreta, "'", sep="")
         print()
      imprimirMenuPrincipal()
      opcaoPrincipal = int(input("Escolha uma opcao: "))
      print()
   elif (opcaoPrincipal==3):
      # nao faz nada, mas nao consegui deixar sem nenhum comando sem dar erro
      a = 1
   else:
      print("Opcao invalida")
      opcaoPrincipal = int(input("Escolha uma opcao: "))
      print()

print("Obrigado por jogar o Jogo da Forca!")

arquivo.close()