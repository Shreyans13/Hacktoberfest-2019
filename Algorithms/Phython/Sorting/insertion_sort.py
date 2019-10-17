#Implementating Insertion Sort in Python

#define function to sorting
def insertionSort(A):

    #go through all the elements in the array 
    for j in range(1,len(A)):
        key = A[j]
        i = j-1
        
        while (i>=0 and A[i]>key):
            A[i+1] = A[i]
            i = i-1
        A[i+1] = key

#defining a array without size
A = []

#getting input from user
for i in range(4):
    #add values to arrray
    A.append(eval(input('enter: ')))

#print values before sorting
print(A)
#calling the insertionSort funtion
insertionSort(A)
#printing the sorted array
print(A)