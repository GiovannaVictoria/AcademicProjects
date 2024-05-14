def mergesort(A):
    if len(A) <= 1:
        return A
    L = A[:len(A)//2]
    R = A[len(A)//2:]
    L = mergesort(L)
    R = mergesort(R)
    return merge(L, R)

def merge(L, R):
    result = []
    i = j = 0
    while i < len(L) and j < len(R):
        if L[i] >= R[j]:
            result.append(L[i])
            i += 1
        else:
            result.append(R[j])
            j += 1
    result += L[i:]
    result += R[j:]
    return result

N = int(input())
for i in range(N):
    linha = input().split()
    K, C = int(linha[0]), int(linha[1])
    A = list(map(float, linha[2:]))
    A = mergesort(A)
    print('%.2f' % A[K-1])

