import random

def partition(A, low, high):
    pivot_index = random.randint(low, high)
    pivot = A[pivot_index]
    A[pivot_index], A[high] = A[high], A[pivot_index]
    i = low
    for j in range(low, high):
        if A[j] >= pivot:
            A[i], A[j] = A[j], A[i]
            i += 1
    A[i], A[high] = A[high], A[i]
    return i

def quickselect(A, low, high, k):
    if low == high:
        return A[low]
    pivot_index = partition(A, low, high)
    if k == pivot_index:
        return A[k]
    elif k < pivot_index:
        return quickselect(A, low, pivot_index - 1, k)
    else:
        return quickselect(A, pivot_index + 1, high, k)

N = int(input())
for i in range(N):
    linha = input().split()
    K, C = int(linha[0]), int(linha[1])
    A = list(map(float, linha[2:]))
    result = quickselect(A, 0, len(A) - 1, K - 1)
    print('%.2f' % result)

