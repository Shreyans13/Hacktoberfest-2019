#Implementating Quick Sort in Python

#define function for partition and sorting
def Partition(A, p, r):
    x = A[r]
    i = p - 1
    for j in range(p, r):
        if(A[j] <= x):
            i = i + 1
            A[i], A[j] = A[j], A[i]
    A[i + 1], A[r] = A[r], A[i + 1]
    return i + 1

#repeating the process
def QuickSort(A, p, r):
    if(p < r):
        q = Partition(A, p, r)
        QuickSort(A, p, q - 1)
        QuickSort(A, q + 1, r)

#defining a array
a = []

#getting input from user and add them into the array
for i in range(5):
    a.append(eval(input('Enetr: ')))

#calling the function
QuickSort(a, 0, 4)
#print the elements in the sorted array
print(a)