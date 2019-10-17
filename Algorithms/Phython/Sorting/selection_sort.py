#Implementating Selection Sort in Python

#define function to sorting
def selectionSort(A):
    n = len(A)
    for j in range(n-1):
        smallest = j
        for i in range(j+1,n):
            if A[i]< A[smallest]:
                smallest = i
        A[j],A[smallest] = A[smallest],A[j]

#defining a array without size
A = []

#getting input from user
for i in range(4):
    #add elements to arrray
    A.append(eval(input('Enter: ')))

#print elements before sorting
print(A)
#calling the selectionSort methoed
selectionSort(A)
#print elements after sorted 
print(A)