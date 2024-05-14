import math
import heapq

def dijkstra(grafo, origem):
    # inicializacao
    heap = [(0, origem)]
    distancias = []
    for i in range(len(grafo)):
        distancias.append(math.inf)
    distancias[origem] = 0
    while len(heap)>0:
        distanciaAtual, no = heapq.heappop(heap)
        if distanciaAtual <= distancias[no]:
            for vizinho in range(len(grafo)):
                if grafo[no][vizinho] > 0:
                    distanciaNova = distanciaAtual + grafo[no][vizinho]
                    # relaxamento
                    if distanciaNova < distancias[vizinho]:
                        distancias[vizinho] = distanciaNova
                        heapq.heappush(heap, (distanciaNova, vizinho))
    return distancias

def criarMatriz (m, n):
    matriz = []
    for i in range(m):
        linha = []
        for j in range(n):
            linha.append(0)
        matriz.append(linha)
    return matriz

linha = input().split()
salas, corredores, tubulacoes, nroConsultas = int(linha[0]), int(linha[1]), int(linha[2]), int(linha[3])

linha = input().split()
arestasCorredor = list(map(float, linha))

linha = input().split()
arestasTubulacao = list(map(float, linha))

consultas = []
for i in range(0, nroConsultas):
    c = int(input())
    consultas.append(c)

verdadeiro = criarMatriz(salas, salas)
impostor = criarMatriz(salas, salas)

for i in range(0, 3*corredores, 3):
    verdadeiro[(int)(arestasCorredor[i])][(int)(arestasCorredor[i+1])] = (arestasCorredor[i+2])
    verdadeiro[(int)(arestasCorredor[i+1])][(int)(arestasCorredor[i])] = (arestasCorredor[i+2])
    
for i in range(0, 2*tubulacoes, 2):
    impostor[(int)(arestasTubulacao[i])][(int)(arestasTubulacao[i+1])] = 1
    impostor[(int)(arestasTubulacao[i+1])][(int)(arestasTubulacao[i])] = 1
for i in range(0, 3*corredores, 3):
    if (impostor[(int)(arestasCorredor[i])][(int)(arestasCorredor[i+1])]==0):
        impostor[(int)(arestasCorredor[i])][(int)(arestasCorredor[i+1])] = (arestasCorredor[i+2])
        impostor[(int)(arestasCorredor[i+1])][(int)(arestasCorredor[i])] = (arestasCorredor[i+2])
    else:
        if ((arestasCorredor[i+2])<impostor[(int)(arestasCorredor[i])][(int)(arestasCorredor[i+1])]):
            impostor[(int)(arestasCorredor[i])][(int)(arestasCorredor[i+1])] = arestasCorredor[i+2]
            impostor[(int)(arestasCorredor[i+1])][(int)(arestasCorredor[i])] = arestasCorredor[i+2]

distanciaI = dijkstra(impostor, 0)
distanciaV = dijkstra(verdadeiro, 0)
for i in range(nroConsultas):
    if (distanciaI[consultas[i]]<distanciaV[consultas[i]]):
        print("defeat")
    else:
        print("victory")
