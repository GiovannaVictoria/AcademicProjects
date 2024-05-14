def mergesort (A):
    if (len(A)<=1):
        return
    L = A[:len(A)//2]
    R = A[len(A)//2:]
    mergesort(L)
    mergesort(R)
    i, j, k = 0, 0, 0
    while i < len(L) and j < len(R):
        if L[i] >= R[j]:
            A[k] = L[i]
            i += 1
        else:
            A[k] = R[j]
            j += 1
        k += 1
    while i < len(L):
        A[k] = L[i]
        i += 1
        k += 1
    while j < len(R):
        A[k] = R[j]
        j += 1
        k += 1

N = int(input())
for i in range(N):
    linha = input().split()
    K, C = int(linha[0]), int(linha[1])
    A = list(map(float, linha[2:]))
    mergesort(A)
    print('%.2f' % A[K-1])
